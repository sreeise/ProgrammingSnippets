extern crate serde;
extern crate serde_json;

/*
Serde is a crate that can store data structures as Json.
*/

#[derive(Serialize, Deserialize, Debug)]
struct Point {
    x: i32,
    y: i32,
}

#[cfg(test)]
mod test_json_write {
    use super::*;

    #[test]
    fn test_print_serde() {
        let point = Point { x: 1, y: 2 };
        // Convert the Point to a JSON string.
        let serialized = serde_json::to_string(&point).unwrap();

        // Convert the JSON string back to a Point.
        let deserialized: Point = serde_json::from_str(&serialized).unwrap();
        assert_eq!(deserialized.x, 1);
        assert_eq!(deserialized.y, 2);
    }
}
