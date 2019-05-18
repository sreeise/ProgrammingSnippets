use reqwest::*;
use std::fs;
use std::fs::OpenOptions;
use std::io::{copy, ErrorKind};
use std::ops::Try;
use std::path::Path;
use std::path::PathBuf;
use std::sync::mpsc;
use std::thread;

pub struct FileRetriever;

impl FileRetriever {
    pub fn download<P: AsRef<Path>>(directory: P, target: &str) -> std::io::Result<PathBuf> {
        // Create the directory if it does not exist.
        if let Some(location) = directory.as_ref().to_str() {
            if !Path::new(&location).exists() {
                fs::create_dir_all(&directory).ok().unwrap_or_default();
            }
        }

        // Fetch the request which returns a PathBuf (result.0) and Response (result.1).
        // If the request is successful copy its contents to the new file.
        match FileRetriever::fetch_url(directory, target) {
            Ok(mut result) => {
                let (sender, receiver) = mpsc::channel();

                let handle = thread::spawn(move || {
                    let mut file_writer = OpenOptions::new()
                        .create(true)
                        .write(true)
                        .read(true)
                        .open(&result.0)
                        .expect("Error performing one of create, write, or read path given.");
                    copy(&mut result.1, &mut file_writer)
                        .expect("Unknown error copying response contents.");
                    sender
                        .send(Some(result.0))
                        .expect("Error sending PathBuf from download.");
                });
                handle.join().expect("Thread could not be joined");

                match receiver.recv() {
                    Ok(t) => Ok(t.unwrap()),
                    Err(e) => Err(std::io::Error::new(
                        ErrorKind::InvalidData,
                        "Could not get file content in response",
                    )),
                }
            }
            Err(e) => Err(e),
        }
    }

    pub fn download_with_bearer<P: AsRef<Path>>(
        directory: P,
        target: &str,
        access_token: &str,
    ) -> std::io::Result<PathBuf> {
        // Create the directory if it does not exist.
        if let Some(location) = directory.as_ref().to_str() {
            if !Path::new(&location).exists() {
                fs::create_dir_all(&directory).ok().unwrap_or_default();
            }
        }

        // Fetch the request which returns a PathBuf (result.0) and Response (result.1).
        // If the request is successful copy its contents to the new file.
        match FileRetriever::fetch_url_bearer(directory, target, access_token) {
            Ok(mut result) => {
                let (sender, receiver) = mpsc::channel();

                let handle = thread::spawn(move || {
                    let mut file_writer = OpenOptions::new()
                        .create(true)
                        .write(true)
                        .read(true)
                        .open(&result.0)
                        .expect("Error performing one of create, write, or read path given.");
                    copy(&mut result.1, &mut file_writer)
                        .expect("Unknown error copying response contents.");
                    sender
                        .send(Some(result.0))
                        .expect("Error sending PathBuf from download.");
                });
                handle.join().expect("Thread could not be joined");

                match receiver.recv() {
                    Ok(t) => Ok(t.unwrap()),
                    Err(e) => Err(std::io::Error::new(
                        ErrorKind::InvalidData,
                        "Could not get file content in response",
                    )),
                }
            }
            Err(e) => Err(e),
        }
    }

    pub fn download_as<P: AsRef<Path>>(
        directory: P,
        target: &str,
        name: &str,
    ) -> std::io::Result<PathBuf> {
        // Create the directory if it does not exist.
        if let Some(location) = directory.as_ref().to_str() {
            if !Path::new(&location).exists() {
                fs::create_dir_all(&directory).into_result()?;
            }
        }

        // Fetch the request which returns a PathBuf (result.0) and Response (result.1).
        // If the request is successful copy its contents to the new file.
        match FileRetriever::fetch_url_as(directory, target, Some(name)) {
            Ok(mut result) => {
                let (sender, receiver) = mpsc::channel();

                let handle = thread::spawn(move || {
                    let mut file_writer = OpenOptions::new()
                        .create(true)
                        .write(true)
                        .read(true)
                        .open(&result.0)
                        .expect("Error performing one of create, write, or read path given.");
                    copy(&mut result.1, &mut file_writer)
                        .expect("Unknown error copying response contents.");
                    sender.send(Some(result.0)).unwrap_or_default();
                });
                handle.join().expect("Thread could not be joined");

                match receiver.recv() {
                    Ok(t) => Ok(t.unwrap()),
                    Err(e) => Err(std::io::Error::new(ErrorKind::InvalidData, e)),
                }
            }
            Err(e) => Err(e),
        }
    }

    pub fn fetch_url<P: AsRef<Path>>(
        directory: P,
        target_url: &str,
    ) -> std::io::Result<(PathBuf, Response)> {
        let response = reqwest::get(target_url).unwrap();
        FileRetriever::parse_response(directory, response)
    }

    pub fn fetch_url_bearer<P: AsRef<Path>>(
        directory: P,
        target_url: &str,
        access_token: &str,
    ) -> std::io::Result<(PathBuf, Response)> {
        let client = reqwest::Client::builder().build().unwrap();
        let response = client
            .get(target_url)
            .header(header::AUTHORIZATION, access_token)
            .send()
            .unwrap();

        FileRetriever::parse_response(directory, response)
    }

    fn parse_response<P: AsRef<Path>>(
        directory: P,
        response: Response,
    ) -> std::io::Result<(PathBuf, Response)> {
        match response
            .url()
            .path_segments()
            .and_then(std::iter::Iterator::last)
            .and_then(|name| if name.is_empty() { None } else { Some(name) })
        {
            Some(name) => {
                let dir = directory.as_ref().join(name);
                Ok((dir, response))
            }
            None => Err(std::io::Error::new(
                ErrorKind::InvalidData,
                "Could not get file content in response",
            )),
        }
    }

    fn fetch_url_as<P: AsRef<Path>>(
        directory: P,
        target_url: &str,
        file_name: Option<&str>,
    ) -> std::io::Result<(PathBuf, Response)> {
        let response = reqwest::get(target_url).unwrap();
        match response
            .url()
            .path_segments()
            .and_then(std::iter::Iterator::last)
            .and_then(|name| {
                if file_name.is_some() {
                    file_name
                } else if name.is_empty() {
                    None
                } else {
                    Some(name)
                }
            }) {
            Some(name) => {
                let dir = directory.as_ref().join(name);
                Ok((dir, response))
            }
            None => Err(std::io::Error::new(
                ErrorKind::InvalidData,
                "Could not get file content in response",
            )),
        }
    }
}
