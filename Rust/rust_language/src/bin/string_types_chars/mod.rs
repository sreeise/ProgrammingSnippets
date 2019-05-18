/*
string 	    String
slice 	    &str or something that dereferences to one, like String or Rc<String>
ch 	        char
n 	        usize, a length
i, j 	    usize, a byte offset
range 	    A range of usize byte offsets using .. syntax
pattern 	Any pattern type: char, String, &str, &[char], or FnMut(char) -> bool


Slices and Strings implement AsRef<str>, AsRef<[u8]>, AsRef<Path>, AsRef<OsStr>, and Borrow<str>
*/

fn string_types() {
    // String type that is a heap-allocated buffer - stored on the heap
    let s = String::new();

    // Allocate a String with a pre-allocated buffer that holds the amount
    // of bytes specified
    let string_pre_allocated = String::with_capacity(10); // allocate 10 bytes

    // String literal
    let string_literal = "stirng literal";

    // String literal to a String
    let sl_to_string = "string literal".to_string();

    // String iterator
    let string_to_collect = "Hel lo";
    let str_joined: String = string_to_collect
        .chars()
        .filter(|c| !c.is_whitespace())
        .collect();
    println!("{:?}", str_joined); // -> "Hello"
}

fn string_extend_methods() {
    let mut string_value = String::from("Hello");

    // push a char
    string_value.push(' ');

    // Push str
    string_value.push_str("World");

    // Extend String with an iterator
    string_value.extend(" ! ".split_whitespace());
    println!("{:?}", string_value); // -> "Hello World!"
}

fn remove_string_values() {
    let mut string_value = String::from("Hello World!!!!");

    // Discard all characters after byte offset
    string_value.truncate(12);
    println!("{:?}", string_value); // -> "Hello World!"

    // Remove last character of String
    string_value.pop();
    println!("{:?}", string_value); // -> "Hello World"

    string_value.remove(6);
    println!("{:?}", string_value); // -> "World"

    // Iterator over range of bytes and removes the characters
    // Items after range are shifted to the front
    let s = string_value.drain(0..2).collect::<String>();
    println!("{}", s);
}
