/*
File IO

Sources of Code and Definitions may be from:
https://github.com/ProgrammingRust/examples

Buffered Readers: Readers and writers can be buffered, which simply
                  means they have a chunk of memory (a buffer) that holds some
                  input or output data in memory.

The Rust standard library defines File and BufReader as two separate features
to allow for buffered and buffered in files.

Both Readers and Writers are closed when they are dropped.

TcpStream has two-way communication and therefore is both a
Reader and Writer
*/

/*
The traits Read, BufRead, Write, and Seek have a prelude for
only those traits: use std::io::prelude::*;
*/

pub mod fileretriever;
use std::fs;
use std::fs::File;
use std::fs::OpenOptions;
use std::io::BufReader;
use std::io::{self, BufRead, ErrorKind, Read, Write};
use std::path::{Path, PathBuf};

const DEFAULT_BUF_SIZE: usize = 8 * 1024;

/*
Function for copying all bytes from any reader to any writer.
*/
pub fn copy<R: ?Sized, W: ?Sized>(reader: &mut R, writer: &mut W) -> io::Result<u64>
where
    R: Read,
    W: Write,
{
    let mut buf = [0; DEFAULT_BUF_SIZE];
    let mut written = 0;

    loop {
        let len = match reader.read(&mut buf) {
            Ok(0) => return Ok(written),
            Ok(len) => len,
            Err(ref e) if e.kind() == ErrorKind::Interrupted => continue,
            Err(e) => return Err(e),
        };
        writer.write_all(&buf[..len])?;
        written += len as u64;
    }
}

/*
Function that implements Unix grep utility

Grep is a utility for searching plain-text data sets
for lines that match using regular expressions.

Calling lines() requires that the source be of BufRead which
is found in io::stdin().

lock() must be called to lock stdin for the current thread's
exclusive use. It returns a StdinLock value that implements
BufRead.
*/
fn grep(target: &str) -> io::Result<()> {
    let stdin = io::stdin();
    for line_result in stdin.lock().lines() {
        let line = line_result?;
        if line.contains(target) {
            println!("{}", line);
        }
    }
    Ok(())
}

fn grep_generic<R>(target: &str, reader: R) -> io::Result<()>
where
    R: BufRead,
{
    for line_result in reader.lines() {
        let line = line_result?;
        if line.contains(target) {
            println!("{}", line);
        }
    }
    Ok(())
}
/*
Use full syntax for Error or it may reference fmt::Error instead
of error::Error while both are in scope.
*/
fn grep_run() -> Result<(), Box<std::error::Error>> {
    // Get the command-line arguments. The first argument is the
    // string to search for; the rest are filenames.
    let mut args = std::env::args().skip(1);
    let target = match args.next() {
        Some(s) => s,
        None => Err("usage: grep PATTERN FILE...")?,
    };
    let files: Vec<PathBuf> = args.map(PathBuf::from).collect();

    if files.is_empty() {
        let stdin = io::stdin();
        grep_generic(&target, stdin.lock())?;
    } else {
        for file in files {
            let f = File::open(file)?;
            grep_generic(&target, BufReader::new(f))?;
        }
    }

    Ok(())
}

fn grep_start() {
    let result = grep_run();
    if let Err(err) = result {
        let _ = writeln!(io::stderr(), "{}", err);
    }
}

/*
Writer

Writer Methods
    1. writer.write(&buf): writes some of the bytes in the slice buf to the
        underlying stream. It returns an io::Result<usize>. On success, this
        gives the number of bytes written, which may be less than buf.len(), at
        the whim of the stream. Like Reader::read(): this is a low-level method
        that you should avoid using directly.
   3. writer.write_all(&buf): writes all the bytes in the slice buf. Returns Result<()>.
   4. writer.flush(): flushes any buffered data to the underlying stream. Returns Result<()>.

    // Create file
    let file = File::create("tmp.txt")?;

    // Add a new buffer to the writer.
    let writer = BufWriter::new(file);
*/

/*
OpenOptions

For specifying exact behavior in reading or writing files.

After a file is open OpenOption behaves like Reader and Writer
and buffers can be added.
*/
fn open_options() -> Result<(), io::Error> {
    let log = OpenOptions::new()
        .append(true) // if file exists, add to the end
        .open("server.log")?;

    let file = OpenOptions::new()
        .write(true)
        .create_new(true) // fail if file exists
        .open("new_file.txt")?;

    Ok(())
}

/*
OsStr

OsStr is a string type that’s a superset of UTF-8. Its job is to be able to represent
all filenames, command-line arguments, and environment variables on the current system,
whether they’re valid Unicode or not.
*/

/*
Recursively copies a directory tree from one place to another

Copy the existing directory `src` to the target path `dst`.
*/
fn copy_dir_to(src: &Path, dst: &Path) -> io::Result<()> {
    if !dst.is_dir() {
        fs::create_dir(dst)?;
    }

    for entry_result in src.read_dir()? {
        let entry = entry_result?;
        let file_type = entry.file_type()?;
        copy_to(&entry.path(), &file_type, &dst.join(entry.file_name()))?;
    }

    Ok(())
}

/*
Copies individual directory entries
*/
/// Copy whatever is at `src` to the target path `dst`.
fn copy_to(src: &Path, src_type: &fs::FileType, dst: &Path) -> io::Result<()> {
    if src_type.is_file() {
        fs::copy(src, dst)?;
    } else if src_type.is_dir() {
        copy_dir_to(src, dst)?;
    } else {
        return Err(io::Error::new(
            io::ErrorKind::Other,
            format!("don't know how to copy: {}", src.display()),
        ));
    }
    Ok(())
}
