/*
Rust Collections

All Code and Definitions from:
https://doc.rust-lang.org/book/2018-edition/ch08-01-vectors.html
https://doc.rust-lang.org/book/2018-edition/ch08-03-hash-maps.html
https://github.com/Hoverbear/rust-rosetta
*/


use std::collections::{BTreeMap, BinaryHeap, HashMap, HashSet, LinkedList, VecDeque};

// Vectors are implemented using generics and need to know
// the type of values being stored
fn vectors() {
    // Create a new vector with i32 type
    let v: Vec<i32> = Vec::new();

    // Rust can usually infer type when creating a vector as well:
    let v1 = vec![1, 2, 3];

    let mut v2 = Vec::new();

    // Add values to a vector
    v2.push(5);
    v2.push(6);

    // Accessing values stored in vectors

    // Indexing
    let zeroth: &i32 = &v2[0]; // -> 5


    // using get method
    let v2_index = 0;
    match v2.get(1) {
        Some(v2_index) => {
            println!("Element found at index: {}", v2_index);
        },
        None => {
            println!("Element not found at index: {}", v2_index);
        }
    }

    // Loop through a vector
    for i in &v2 {
        println!("{}", i);
    }

    // Add elements to vector in loop
    let mut v3 = vec![100, 32, 57];
    for i in &mut v3 {
        // To change the value that the mutable reference refers to,
        // we have to use the dereference operator (*) to get to the value
        // in i before we can use the += operator
        *i += 50;
    }

    // Use an enum to add multiple types to a vector

    let row = vec![

        SpreadsheetCell::Int(3),
        SpreadsheetCell::Text(String::from("blue")),
        SpreadsheetCell::Float(10.12),
    ];
}

enum SpreadsheetCell {
    Int(i32),
    Float(f64),
    Text(String),
}


/*
Definitions and Code from:
https://doc.rust-lang.org/book/2018-edition/ch08-02-strings.html

The String type, which is provided by Rust’s standard library rather than coded
into the core language, is a growable, mutable, owned, UTF-8 encoded string type

Rust’s standard library also includes a number of other string types, such as
OsString, OsStr, CString, and CStr. Library crates can provide even more
options for storing string data. See how those names all end in String or Str?
They refer to owned and borrowed variants, just like the String and str types
you’ve seen previously. These string types can store text in different
encodings or be represented in memory in a different way

Strings in Rust cannot be indexed by integers because Strings are stored
by the amount of bytes taken up in UTF-8.
Rust actually can interpret Strings in 3 different ways:
    1. Bytes
    2. Scalar Values
    3. Grapheme Clusters
*/

fn string_type() {
    // Create a new String
    let s = String::new();
    // Also
    let data = "String content";
    let s1 = data.to_string();
    // and
    let s2 = "String content".to_string();
    // Using String::from
    let s3 = String::from("String content");
    // String::from and to_string do the same thing, so which you choose is a matter of style.

    // Push method: push_str()
    let mut s4 = String::from("foo");
    s4.push_str("bar");

    // Single character push method: push()
    let mut s5 = String::from("lo");
    s5.push('l'); // s5 -> lol

    // Concatenating String using a Macro
    let string1 = String::from("Hello");
    let string2 = String::from("World");
    let hello_world = format!("{} {}", string1, string2); // -> Hello World

    // String slicing instead of indexing
    // Here, s will be a &str that contains the first 4 bytes of the string
    let hello = "Здравствуйте";
    let s = &hello[0..4];

    // Iterating over Strings using method chars()
    for c in "Hello".chars() {
        println!("{}", c);
    }

    // Iterating over a string and getting the bytes using method bytes()
    for b in "hello".bytes() {
        println!("{}", b);
    }
}

// Arrays ([T]) are stack allocated, fixed size collections of items of the same type.
fn stack_allocated_arrays() {
    let a = [1u8, 2, 3, 4, 5]; // a is of type [u8; 5];
    let b = [0; 256]; // Equivalent to `let b = [0, 0, 0, 0, 0, 0... repeat 256 times]`
    assert_eq!(a.len(), 5);
    assert_eq!(b.len(), 256);
}

// Slices (&[T]) are dynamically sized views into contiguous sequences (arrays, vectors,
// strings)
fn slices() {
    let array = [1, 2, 3, 4, 5];
    let slice = &array[0..2];
    println!("{:?}", slice); // Output: [1, 2]
}

/*
The type HashMap<K, V> stores a mapping of keys of type K to values of type V.
It does this via a hashing function, which determines how it places these
keys and values into memory.

Important HashMap information:
    1. HashMaps are stored on the heap.
    2. All keys must have same type and all values must have the same type
    3. For types that implement the Copy trait, like i32, the values are
        copied into the hash map. For owned values like String the values
        will be moved and the hash map will be the owner of those values
    4. Each key can only have one value associated with it at a time
    5. If we insert a key and a value into a hash map and then insert that
        same key with a different value, the value associated with that
        key will be replaced
    6. HashMap uses a cryptographically secure hashing function that can
        provide resistance to Denial of Service (DoS) attacks. The trade off
        is that the hashing algorithm used is not the fastest.
*/
fn hash_maps() {
    let mut hm = HashMap::new();

    // Insert values into the hash map
    hm.insert(String::from("hello"), 5);
    hm.insert(String::from("world"), 6);

    // Using collect on a vector of tuples
    let teams  = vec![String::from("Blue"), String::from("Yellow")];
    let initial_scores = vec![10, 50];

    // The HashMap<_, _> allows Rust to infer the types that the hash map
    // contains based on the types of the data in the vectors.
    let scores: HashMap<_, _> = teams.iter().zip(initial_scores.iter()).collect();

    // Getting values from a HashMap using the get() method
    let mut scores = HashMap::new();

    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    let team_name = String::from("Blue");
    let score = scores.get(&team_name);

    // Iterate of a HashMap
    for (key, value) in &hm {
        println!("{}: {}", key, value)
    }

    // Using the entry() method to only insert a value if the
    // HashMap does not already contain the key
    let mut entry_map = HashMap::new();
    entry_map.insert(String::from("Blue"), 10);
    entry_map.entry(String::from("Yellow")).or_insert(50);
    entry_map.entry(String::from("Blue")).or_insert(50);

    /*
    The or_insert method on Entry is defined to return a mutable
    reference to the value for the corresponding Entry key if that
    key exists, and if not, inserts the parameter as the new value
    for this key and returns a mutable reference to the new value.
    */

    println!("{:?}", entry_map); // -> {"Blue": 10, "Yellow": 50}

    // Update a HashMap key value based on an old value
    let text = "Hello world Hello Again";
    let mut hm2 = HashMap::new();
    for word in text.split_whitespace() {
        /*
         The or_insert method actually returns a mutable reference
         (&mut V) to the value for this key. Here we store that mutable
         reference in the count variable, so in order to assign to that
         value, we must first dereference count using the asterisk (*).
        */

        let count = hm2.entry(word).or_insert(0);
        *count += 1;
    }

    println!("{:?}", hm2); // -> {"Again": 1, "world": 1, "Hello": 2}
}

// Linked List
//
// A doubly-linked list.
// Use when:
// - You want a Vec or VecDeque of unknown size, and can't tolerate amortization.
// - You want to efficiently split and append lists.
// - You are absolutely certain you really, truly, want a doubly linked list.
fn linked_list() {
    let mut a = LinkedList::new();
    let mut b = LinkedList::new();
    a.push_back(1);
    a.push_back(2);
    b.push_back(3);
    b.push_back(4);

    // A constant-time and -memory operation.
    a.append(&mut b);

    for e in &a {
        println!("{}", e); // prints 1, then 2, then 3, then 4
    }
}

// VecDequeue
//
// A growable ring buffer.
// Use when:
// - You want a Vec that supports efficient insertion at both ends of the sequence.
// - You want a queue.
// - You want a double-ended queue (deque).
fn vec_deque() {
    let mut deque = VecDeque::new();
    deque.push_back(3);
    deque.push_back(4);
    deque.push_back(5);
    assert_eq!(deque.get(1), Some(&4));
}

// BTreeMap
//
// A map based on a B-Tree. According to the Rust documentation, you should use it when:
// - You're interested in what the smallest or largest key-value pair is.
// - You want to find the largest or smallest key that is smaller or larger than something.
// - You want to be able to get all of the entries in order on-demand.
// - You want a sorted map.
fn b_tree_map() {
    let mut map = BTreeMap::new();
    map.insert(1, "a");
    map.insert(2, "b");
    map.insert(3, "c");
    assert_eq!(map.get(&1), Some(&"a"));
}

// HashSet/BTreeSet
//
// Set implementations that use an empty tuple () as the value of their respective maps (and
// implement different methods).
// Use when
// - You just want to remember which keys you've seen.
// - There is no meaningful value to associate with your keys.
// - You just want a set.
fn hash_set_and_b_tree() {
    let mut set = HashSet::new();
    set.insert(1);
    set.insert(2);
    set.insert(3);
    set.insert(2);
    assert_eq!(set.len(), 3);
}

// BinaryHeap
//
// A priority queue implemented with a binary heap. You should use it when
// - You want to store a bunch of elements, but only ever want to process the "biggest" or
//   "most important" one at any given time.
// - You want a priority queue.
fn binary_heap() {
    let mut heap = BinaryHeap::new();
    heap.push(1);
    heap.push(5);
    heap.push(2);
    assert_eq!(heap.peek(), Some(&5));
}