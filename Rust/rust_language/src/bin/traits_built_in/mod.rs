/*
Code references may be from:
    https://github.com/ProgrammingRust
    https://doc.rust-lang.org/book
*/

/*
Index and IndexMut Trait with Default and Copy
*/

/*
The Index Trait
*/
struct Image<P> {
    width: usize,
    pixels: Vec<P>,
}

impl<P: Default + Copy> Image<P> {
    /// Create a new image of the given size.
    fn new(width: usize, height: usize) -> Image<P> {
        Image {
            width,
            pixels: vec![P::default(); width * height],
        }
    }
}

impl<P> std::ops::Index<usize> for Image<P> {
    type Output = [P];
    fn index(&self, row: usize) -> &[P] {
        let start = row * self.width;
        &self.pixels[start..start + self.width]
    }
}

impl<P> std::ops::IndexMut<usize> for Image<P> {
    fn index_mut(&mut self, row: usize) -> &mut [P] {
        let start = row * self.width;
        &mut self.pixels[start..start + self.width]
    }
}

/*
PartialEq and Ordering
*/
use std::cmp::{Ordering, PartialOrd};

/*
Eq and PartialEq can be automatically implemented
*/
#[derive(Debug, Clone, Copy, Eq, PartialEq)]
struct Numbers {
    int: u32,
    dec: u32,
}

#[derive(Debug, PartialEq)]
struct Interval<T> {
    lower: T,
    upper: T,
}

impl<T: PartialOrd> PartialOrd<Interval<T>> for Interval<T> {
    fn partial_cmp(&self, other: &Interval<T>) -> Option<Ordering> {
        if self == other {
            Some(Ordering::Equal)
        } else if self.lower >= other.upper {
            Some(Ordering::Greater)
        } else if self.upper <= other.lower {
            Some(Ordering::Less)
        } else {
            None
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_partial_eq() {
        let item = Numbers { int: 3, dec: 6 };

        assert_eq!(item, Numbers { int: 3, dec: 6 })
    }

    #[test]
    fn test_interval() {
        assert!(
            Interval {
                lower: 10,
                upper: 20
            } < Interval {
                lower: 20,
                upper: 40
            }
        );
        assert!(Interval { lower: 7, upper: 8 } >= Interval { lower: 0, upper: 1 });
        assert!(Interval { lower: 7, upper: 8 } <= Interval { lower: 7, upper: 8 });

        // Overlapping intervals aren't ordered with respect to each other.
        let left = Interval {
            lower: 10,
            upper: 30,
        };
        let right = Interval {
            lower: 20,
            upper: 40,
        };
        assert!(!(left < right));
        assert!(!(left >= right));
    }
}

/*
Ord Trait

Ord says that this function can be used by all
type T that implement the Ord trait.

Ord: Ordered Type
*/
fn min<T: Ord>(value1: T, value2: T) -> T {
    if value1 <= value2 {
        value1
    } else {
        value2
    }
}

/*
Add and Mul
*/
use std::ops::{Add, Mul};

fn vec_multiply<N>(v1: &[N], v2: &[N]) -> N
where
    N: Add<Output = N> + Mul<Output = N> + Default + Copy,
{
    let mut total = N::default();
    for i in 0..v1.len() {
        total = total + v1[i] * v2[i];
    }
    total
}

#[test]
fn test_dot() {
    assert_eq!(vec_multiply(&[1, 2, 3, 4], &[1, 1, 1, 1]), 10);
    assert_eq!(vec_multiply(&[53.0, 7.0], &[1.0, 5.0]), 88.0);
}

/*
Display and Error
*/
use std;
use std::fmt;

#[derive(Debug)]
pub struct ErrorHandle {
    pub message: String,
    pub line: usize,
    pub column: usize,
}

impl fmt::Display for ErrorHandle {
    fn fmt(&self, f: &mut fmt::Formatter) -> Result<(), fmt::Error> {
        write!(f, "{} ({}:{})", self.message, self.line, self.column)
    }
}

impl std::error::Error for ErrorHandle {
    fn description(&self) -> &str {
        &self.message
    }
}

/*
A trait can use the keyword Self as a type.

Using Self as the return type here means that the type of x.clone()
is the same as the type of x.
*/
pub trait Spliceable {
    fn splice(&self, other: &Self) -> Self;
}

/*
Traits can be an extension of another trait.

Every type that implements Splicer must also implement
Spliceable.
*/
trait Splicer: Spliceable {}
