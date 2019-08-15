/*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary
until the first non-whitespace character is found. Then, starting from
this character, takes an optional initial plus or minus sign followed by
as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral
number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid
integral number, or if no such sequence exists because either str is empty
or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:
 - Only the space character ' ' is considered as whitespace character.
 - Assume we are dealing with an environment which could only store
    integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
    If the numerical value is out of the range of representable values,
    INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
*/

pub fn atoi(string: String) -> i32 {
    let s = string.trim();
    if s.is_empty() {
        return 0;
    }

    if let Ok(num) = s.parse::<i32>() {
        return num;
    }

    let s1 = split_int(&s);
    if let Ok(num) = s1.parse::<i32>() {
        return num;
    } else {
        if s1.len() == 1 {
            return 0;
        }

        for (i, byte) in s1.bytes().enumerate() {
            if i == 0 && byte == b'+' || byte == b'-' {
                continue;
            }

            if !is_byte_number(byte) {
                return 0;
            }
        }
    }

    if s.starts_with('-') {
        return std::i32::MIN;
    } else {
        return std::i32::MAX;
    }
}


fn split_int(s: &str) -> &str {
    for (i, byte) in s.bytes().enumerate() {
        if i == 0 {
            if byte == b'-' || byte == b'+' {
                continue;
            } else if !is_byte_number(byte) {
                return "0"
            }
        }

        if i == 1 {
            if byte == b'.' || !is_byte_number(byte) {
                return &s[..i]
            }
        }

        if !is_byte_number(byte) {
            return &s[..i]
        }
    }

    s
}

fn is_byte_number(byte: u8) -> bool {
    match byte {
        48 | 49 | 50 | 51 | 52 | 53 | 54 | 55 | 56 | 57 => true,
        _ => false,
    }
}

#[test]
fn test_atoi() {
    assert_eq!(3, atoi("3.14159".into()));
    assert_eq!(-12, atoi("  -0012a42".into()));
    assert_eq!(0, atoi("+-2".into()));
    assert_eq!(0, atoi("-abc".into()));
}