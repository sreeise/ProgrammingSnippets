/*
Rust Vectors

All Code and Definitions from
https://doc.rust-lang.org/book/2018-edition/ch00-00-introduction.html
*/

use std::fmt::Display;

// Basic vector iter and index print using Display trait
pub fn print_iter<T>(vec_t: Vec<T>) where T: Display  {
    let v_iter = vec_t.iter();

    for (index, item) in v_iter.enumerate() {
        println!("Index: {}, Item: {}", index, item);
    }
}

/*
Takes two vectors and joins the second vector given in the arguments
onto the end of the first vector and retuning the new vector.

Note that this is three completely different vectors and the original
vectors do not get changed.
*/
pub fn join_items<T: Clone>(x: &[T], y: &[T]) -> Vec<T> {
    let mut vec_t: Vec<T> = vec![x[0].clone(); x.len()];

    vec_t.clone_from_slice(x);
    vec_t.extend_from_slice(y);
    vec_t
}

#[cfg(test)]
mod tests_vec_methods {
    use super::*;

    #[test]
    fn tests_join_items() {
        let vec_one : Vec<i32> = vec![1, 4, 32, 3];
        let vec_two : Vec<i32> = vec![1, 3, 8, 5];
        let vec_t = join_items::<i32>(vec_one.as_slice(), vec_two.as_slice());
        assert_eq!(vec_one, [1, 4, 32, 3]);
        assert_eq!(vec_two, [1, 3, 8, 5]);
        assert_eq!(vec_t, [1, 4, 32, 3, 1, 3, 8, 5]);
    }

    #[derive(Clone, Debug, PartialEq)]
    struct TestStruct {
        count: u32,
        name: &'static str,
    }

    #[test]
    fn test_join_items_struct() {
        let vec_struct: Vec<TestStruct> = vec![
            TestStruct { count: 1, name: "Test1" },
            TestStruct { count: 2, name: "Test2" },
        ];

        let vec_struct2 : Vec<TestStruct> = vec![
            TestStruct { count: 3, name: "Test3" },
            TestStruct { count: 4, name: "Test4" },
        ];

        let joined_vec = join_items::<TestStruct>(vec_struct.as_slice(),
                                                  vec_struct.as_slice());
        assert_eq!(joined_vec, [
            TestStruct { count: 1, name: "Test1" },
            TestStruct { count: 2, name: "Test2" },
            TestStruct { count: 1, name: "Test1" },
            TestStruct { count: 2, name: "Test2" }
        ]);
    }
}
