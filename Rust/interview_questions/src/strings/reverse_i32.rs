
pub fn reverse(x: i32) -> i32 {
    let mut is_negative = false;

    if x < 0 {
        is_negative = true;
    }

    let s = x.to_string();
    let mut vec: Vec<&str> = s.split("").collect();
    vec.retain(|s| !s.is_empty());
    vec.reverse();
    if is_negative {
        vec.pop();
        let mut num = vec.join("");
        let mut string = String::new();
        string.push('-');
        string.push_str(num.as_str());
        string.parse::<i32>().unwrap_or(0)
    } else {
        let num = vec.join("");
        num.parse::<i32>().unwrap_or(0)
    }
}