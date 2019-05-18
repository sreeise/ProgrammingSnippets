/*
Sorting Algorithms

All Code and Definitions from:
https://github.com/Hoverbear/rust-rosetta
*/

/*
Bubble Sort
*/
pub fn bubble_sort<T: PartialOrd + Clone>(collection: &[T]) -> Vec<T> {
    let mut result: Vec<T> = collection.into();
    for _ in 0..result.len() {
        let mut swaps = 0;
        for i in 1..result.len() {
            if result[i - 1] > result[i] {
                result.swap(i - 1, i);
                swaps += 1;
            }
        }
        if swaps == 0 {
            break;
        }
    }
    result
}

/*
Selection Sort

Looks for the smallest element in an array and
moves it to the beginning or next place after the
previous element was placed.
*/
fn selection_sort<T: Ord>(v: &mut [T]) {
    if v.is_empty() {
        return;
    }

    let len = v.len();

    for j in 0..len - 1 {
        let mut min_index = j;
        for i in j + 1..len {
            if v[i] <= v[min_index] {
                min_index = i;
            }
        }
        v.swap(j, min_index);
    }
}

/*
Merge Sort

Divide and conquer sorting technique by dividing arrays into equal
halves, sorts the values, and then combines them.
*/

// This is an idiomatic-but-slow implementation. A more efficient implementation
// would use `unsafe` to avoid allocating so many temporary vectors.

fn merge_sort<E: PartialOrd + Clone>(arr: &[E]) -> Vec<E> {
    if arr.len() <= 1 {
        return arr.to_vec();
    }
    let midpoint = arr.len() / 2;
    let left = merge_sort(&arr[0..midpoint]);
    let right = merge_sort(&arr[midpoint..]);
    merge(&left[..], &right[..])
}

fn merge<E: PartialOrd + Clone>(left: &[E], right: &[E]) -> Vec<E> {
    let mut merged = Vec::with_capacity(left.len() + right.len());
    let mut i = 0;
    let mut j = 0;
    while i < left.len() && j < right.len() {
        if left[i] <= right[j] {
            merged.push(left[i].clone());
            i += 1;
        } else {
            merged.push(right[j].clone());
            j += 1;
        }
    }
    while i < left.len() {
        merged.push(left[i].clone());
        i += 1;
    }
    while j < right.len() {
        merged.push(right[j].clone());
        j += 1;
    }
    merged
}

fn print_merge_sort() {
    let arr = [1i32, 9, 3, 2, 1003, 23, -123, 7];
    let sorted = merge_sort(&arr);
    println!("{:?}", sorted);
}

/*
Sorting Composite Structures
*/

#[derive(Debug, PartialEq)]
struct Element {
    name: String,
    value: String,
}

impl Element {
    fn new(name: &str, value: &str) -> Element {
        Element {
            name: name.to_string(),
            value: value.to_string(),
        }
    }
}

fn sort_by_name(elements: &mut Vec<Element>) {
    elements.sort_by(|a, b| a.name.cmp(&b.name));
}

fn print_struct_sort() {
    let mut values = vec![
        Element::new("Iron", "Fe"),
        Element::new("Cobalt", "Co"),
        Element::new("Nickel", "Ni"),
        Element::new("Copper", "Cu"),
        Element::new("Zinc", "Zn"),
    ];
    sort_by_name(&mut values);
    println!("{:?}", values);
}

/*
Tests for Sorting Methods
*/

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn tests_merge_sorted() {
        let arr = [1i32, 2, 3, 4, 6, 8];
        assert_eq!(merge_sort(&arr), arr.to_vec());
    }

    #[test]
    fn tests_merge_reverse() {
        let arr = [8i32, 6, 4, 3, 2, 1];
        assert_eq!(merge_sort(&arr), vec![1i32, 2, 3, 4, 6, 8]);
    }

    #[test]
    fn tests_merge_random() {
        let arr = [12i32, 54, 2, 93, 13, 43, 15, 299, 234];
        assert_eq!(
            merge_sort(&arr),
            vec![2i32, 12, 13, 15, 43, 54, 93, 234, 299]
        );
    }

    #[test]
    fn tests_struct_sort() {
        let mut values = vec![
            Element::new("Iron", "Fe"),
            Element::new("Cobalt", "Co"),
            Element::new("Nickel", "Ni"),
            Element::new("Copper", "Cu"),
            Element::new("Zinc", "Zn"),
        ];
        sort_by_name(&mut values);
        assert_eq!(
            values,
            vec![
                Element::new("Cobalt", "Co"),
                Element::new("Copper", "Cu"),
                Element::new("Iron", "Fe"),
                Element::new("Nickel", "Ni"),
                Element::new("Zinc", "Zn"),
            ]
        );
    }
}
