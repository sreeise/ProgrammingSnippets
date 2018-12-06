extern crate webserver;

use webserver::ThreadPool;
use std::io::prelude::*;
use std::net::TcpStream;
use std::net::TcpListener;
use std::fs::File;

fn main() {
    start("127.0.0.1:7878", 4);
}

fn start(addr: &str, thread_pool_size: usize) {
    let listener = TcpListener::bind(addr).unwrap();
    let pool = ThreadPool::new(thread_pool_size);
    for stream in listener.incoming() {
        let stream = stream.unwrap();

        pool.execute(|| {
            connect(stream);
        })
    }
}

fn connect(mut stream: TcpStream) {
    let mut buffer = [0; 512];
    stream.read(&mut buffer).unwrap();

    let get = b"GET / HTTP/1.1\r\n";

    let (status_line, filename) = if buffer.starts_with(get) {
        ("HTTP/1.1 200 OK\r\n\r\n", "hello.html")
    } else {
        ("HTTP/1.1 404 NOT FOUND\r\n\r\n", "404.html")
    };

    let mut file = File::open(filename).unwrap();
    let mut contents = String::new();

    file.read_to_string(&mut contents).unwrap();

    let response = format!("{}{}", status_line, contents);

    stream.write(response.as_bytes()).unwrap();
    stream.flush().unwrap();
}
