/*
Command Line Processes

Code and Definitions may be from:
https://doc.rust-lang.org/std/process/struct.Command.html
*/

/*
std::process::Command is a process builder.
*/
use std::process::{Command, Stdio};

/*
List current directory and then go to root and
list root directory.
*/
pub fn list_directory() {
    let mut list_dir = Command::new("ls");
    list_dir.status().expect("process failed to execute");
    println!();

    list_dir.current_dir("/");
    list_dir.status().expect("process failed to execute");
}

/*
Spawn the SH Shell

sh: Command line interpreter - executes specific instructions in programming
    and scripting languages.

arg: An argument to give the command line. Must be one argument per arg() call.
*/
fn print_hello() {
    let mut echo_hello = Command::new("sh");
    echo_hello
        .arg("-c")
        .arg("echo hello");
    let hello_1 = echo_hello.output().expect("failed to execute process");
    let hello_2 = echo_hello.output().expect("failed to execute process");
}

/*
Add multiple entries to .arg()

    1. -a
        Do not ignore entries starting with .
    2. -i
        List indexes of files
*/
pub fn multiple_args() {
    Command::new("ls")
        .args(&["-a", "-i"])
        .spawn()
        .expect("ls command failed");
}

/*
Environment Variables
*/
pub fn print_env() {
    Command::new("ls")
        .env("PATH", "/bin")
        .spawn()
        .expect("ls command failed to start");
}

/*
Remove Environment Variable Mapping
*/
fn remove_env() {
    Command::new("ls")
        .env_remove("PATH")
        .spawn()
        .expect("ls command failed to start");
}

/*
Inherit Standard Output
*/

/*
Using stdout
*/
pub fn inherit_output_using_stdout() {
    let output = Command::new("echo")
        .arg("Hello, world!")
        .stdout(Stdio::inherit())
        .output()
        .expect("Failed to execute command");

    assert_eq!(String::from_utf8_lossy(&output.stdout), "");
    // "Hello, world!" echoed to console
}

/*
Using stdin
*/
fn inherit_output_using_stdin() {
    let output = Command::new("rev")
        .stdin(Stdio::inherit())
        .stdout(Stdio::piped())
        .output()
        .expect("Failed to execute command");

    println!("You piped in the reverse of: {}", String::from_utf8_lossy(&output.stdout));
}