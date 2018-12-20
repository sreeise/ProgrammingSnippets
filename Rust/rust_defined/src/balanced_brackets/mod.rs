

pub struct Brackets {
    to_parse: String,
    vec_char: Vec<char>,
}

impl Brackets {
    pub fn new(to_parse: &str) -> Brackets {
        Brackets {
            to_parse: String::from(to_parse),
            vec_char: Vec::new(),
        }
    }
}

pub trait Balanced {
    fn is_balanced(&self) -> bool;
    fn stack_is_balanced(&mut self) -> bool;
}


impl Balanced for Brackets {
    fn is_balanced(&self) -> bool {
        let mut count = 0;
        let mut count_bracket = 0;
        let mut count_parenthesis = 0;

        for bracket in self.to_parse.chars() {
            match bracket {
                '[' => { count += 1; },
                ']' => { count -= 1; },
                '{' => { count_bracket += 1; },
                '}' => { count_bracket -= 1; },
                '(' => { count_parenthesis += 1; },
                ')' => { count_parenthesis -= 1; },
                _ => {},
            };
            if count < 0 || count_bracket < 0 || count_parenthesis < 0 {
                return false;
            }


        }
        if count == 0 && count_bracket == 0 && count_parenthesis == 0 {
            return true;
        }
        return false;
    }

    /*
    Bracket Algorithm for Stack


    1. Whenever an opening bracket appears, we push it onto the stack.
    2. If a closing bracket appears and if it matches the opening bracket at the top of the
        stack, it means that the brackets are balanced and we pop the opening bracket out of the
        stack and continue analyzing the string.
    3. If the closing bracket doesn't match the opening bracket at the top of the stack, we can
        infer that the string is not balanced return false.
    4. After processing the string completely and if the stack is empty, the string is balanced,
        return true else return false.
*/
    fn stack_is_balanced(&mut self) -> bool {
        for bracket in self.to_parse.chars() {
            match bracket {
                '[' => self.vec_char.push('['),
                ']' =>  {
                    if self.vec_char.is_empty() {
                        return false;
                    }
                    if self.vec_char.last().unwrap() != &'[' {
                        return false;
                    } else {
                        self.vec_char.pop().unwrap();
                    }
                },
                '{' => self.vec_char.push('{'),
                '}' =>  {
                    if self.vec_char.is_empty() {
                        return false;
                    }
                    if self.vec_char.last().unwrap() != &'{' {
                        return false;
                    } else {
                        self.vec_char.pop().unwrap();
                    }
                },
                '(' => self.vec_char.push('('),
                ')' =>  {
                    if self.vec_char.is_empty() {
                        return false;
                    }
                    if self.vec_char.last().unwrap() != &'(' {
                        return false;
                    } else {
                        self.vec_char.pop().unwrap();
                    }
                },
                _ => {},
            };
        }
        self.vec_char.is_empty() == true
    }
}

#[test]
fn test_brackets() {
    let mut brackets = Brackets::new("[[]()[]]");
    assert_eq!(true, brackets.stack_is_balanced());
    assert_eq!(true, brackets.is_balanced());

    let test_str = "{ 'BracketType': 'Test', 'Bracket': {\
        'Type': 'All'}, [1, 3, 4, 7], (123)}";
    let mut brackets2 = Brackets::new(test_str);
    assert_eq!(true, brackets2.stack_is_balanced());
    assert_eq!(true, brackets2.is_balanced());

    let mut brackets3 = Brackets::new("[[]]()}[][]");
    assert_eq!(false, brackets3.is_balanced());
    assert_eq!(false, brackets3.stack_is_balanced());
}
