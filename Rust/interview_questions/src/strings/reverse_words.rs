/*
Given an input string, reverse the string word by word.

Example:
    Input: "the sky is blue"
    Output: "blue is sky the"
*/

pub fn reverse_words(s: String) -> String {
    let mut string = s.as_str();
    let mut vec: Vec<&str> =  string.trim().split_terminator(" ").collect();
    vec.retain(|s| !s.is_empty());
    vec.iter().map(|s| s.trim());
    vec.reverse();
    vec.join(" ")
}

#[test]
fn reverse_word_test() {
    let word = "the sky is blue";
    let reversed = reverse_words(word.into());
    println!("{:#?}", reversed);
    assert_eq!(reversed, "blue is sky the");
}
