# Rust Programming snippets and reference. 
Note the main README.md file. These files are not a guide, and code may be random.

Some code here has been taken from 

    https://doc.rust-lang.org/book/2018-edition/ch00-00-introduction.html

This is the website for the Rust programming language book featured on the Rust website.

### Cargo Commands

#### New project

    $ cargo new <Project Name>

#### Compile

    $ cargo build
    
#### Run

    $ cargo run
    
or

    $ cargo ./target/debug/<Project>

In this directory this will be:

    $ cargo ./target/debug/rust_reference
    
     
#### Make sure project compiles without creating executable

    $ cargo check 
    
#### Build project for release

    $ cargo build --Release
    
#### Rust Crates

Crates are libraries/dependencies specified in a projects Cargo.toml file.

#### Adding a Crate

Add the Crate name and version number to Cargo.toml:

    rand = "0.3.14"
    
This adds the rand crate, for random numbers, on the next Cargo build.

#### Get information on dependencies

    cargo doc --open
    
Creates documentation for every dependency listed in Cargo.toml
and opens them in a web browser.
    
#### Update dependencies

    $ cargo update
    
This updates to the next release after the current version. If there
is a release after this, it must be changed in the cargo.toml file.
