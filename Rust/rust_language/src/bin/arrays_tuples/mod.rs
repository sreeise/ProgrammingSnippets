fn tuples() {
    // Tuples are fixed length groups that can contain multiple types
    let tup = (500, 6.4, 1);

    // Destructuring a tuple and assigning the values to variables
    let (x, y, z) = tup;

    println!("The value of x is: {}", x);
    println!("The value of y is: {}", y);
    println!("The value of z is: {}", z);

    // Accessing tuples through . notation
    let x: (i32, f64, u8) = (500, 6.4, 1);

    let five_hundred = x.0;

    let six_point_four = x.1;

    let one = x.2;
    println!("The value of one is: {}", one);
    println!("The value of five_hundred is: {}", five_hundred);
    println!("The value of six_point_four is: {}", six_point_four);
}

fn arrays() {
    // Arrays in Rust are fixed size like tuples
    // Array are represented by single chunks of memory on the stack.

    // The type shown here is [i32, 4]
    let arr = [1, 2, 3, 4];
    let first = arr[0];
    let last = arr[3];
    println!("The value of first is: {}", first);
    println!("The value of last is: {}", last);
}

fn conditional_statements() {
    let condition = true;
    // Set number to 5 if the boolean condition variable is true
    // and 6 if false
    let number = if condition {
        5
    } else {
        6
    };

    // Print the number
    println!("The value of number is: {}", number);
}
