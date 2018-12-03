/*
Vec and dynamically resized data structure
*/
mod dynamic_resize {
    #[derive(Debug)]
    pub struct Item {
        name: String,
        text: String,
    }

    impl Item {
        #[allow(dead_code)]
        fn new(name: &str, text: &str) -> Item {
            Item {
                name: String::from(name),
                text: String::from(text),
            }
        }

        #[allow(dead_code)]
        pub fn name_of(&self) -> &str {
            &self.name
        }

        #[allow(dead_code)]
        pub fn text_of(&self) -> &str {
            &self.text
        }
    }

    #[derive(Debug)]
    pub struct List<T> {
        pub length: usize,
        pub vec_list: Vec<T>,
    }

    trait Dynamic {
        fn new() -> List<Item>;
        fn length(&self) -> usize;
        fn add_item(&mut self, item: Item);
        fn remove_item(&mut self, index: usize);
        fn print_list(&self);
        fn update_length(&mut self);
        fn merge(&mut self, vec_list: Vec<Item>);
    }

    impl Dynamic for List<Item> {
        fn new() -> List<Item> {
            List {
                length: 0,
                vec_list: Vec::new(),
            }
        }

        fn length(&self) -> usize {
            self.vec_list.len()
        }

        fn add_item(&mut self, item: Item) {
            self.vec_list.push(item);
            self.update_length();
        }

        fn remove_item(&mut self, index: usize) {
            self.vec_list.remove(index);
            self.update_length();
        }

        fn print_list(&self) {
            let v_iter = self.vec_list.iter();
            for val in v_iter {
                println!("Val: {:?}", val);
            }
        }

        fn update_length(&mut self) {
            self.length = self.length();
        }

        /// Merges given Vec<Item> into self Vec<Item>
        fn merge(&mut self, vec_array_list: Vec<Item>) {
            self.vec_list.extend(vec_array_list.into_iter());
        }
    }

    #[cfg(test)]
    mod tests {
        // Tests the Item methods
        #[test]
        fn test_dynamic_item_create() {
            use super::*;
            let item = Item::new("name", "text");
            assert_eq!(item.name_of(), "name");
            assert_eq!(item.text_of(), "text");
        }

        // Test that the length is updated on List after add and remove item
        #[test]
        fn test_dynamic_update_length() {
            use super::*;

            let mut list = List::new();
            assert_eq!(list.length, 0);
            let item1 = Item::new("name1", "text1");
            list.add_item(item1);
            assert_eq!(list.length, 1);
            list.remove_item(0);
            assert_eq!(list.length, 0);
        }

        // Test that Items can be added to and removed from List<Item> Vec
        #[test]
        fn test_dynamic_resize() {
            use super::*;
            let mut list = List::new();
            let item1 = Item::new("name1", "text1");

            let item2 = Item::new("name2", "text2");
            list.add_item(item1);
            assert_eq!(list.length(), 1);
            list.remove_item(0);
            assert_eq!(list.length(), 0);
            list.add_item(item2);
            assert_eq!(list.length(), 1);
        }

        // Tests merge method for taking a Vec<Item> and
        // merging it's items in the List Vec<Item>
        #[test]
        fn test_dynamic_merge() {
            use super::*;

            let mut list = List::new();
            let item1 = Item::new("name1", "text1");
            list.add_item(item1);
            assert_eq!(list.length(), 1);

            let item2 = Item::new("name2", "text2");
            let item3 = Item::new("name3", "text3");

            let mut vec2 = Vec::new();
            vec2.push(item2);
            vec2.push(item3);

            list.merge(vec2);
            assert_eq!(list.length(), 3);
        }

        // Tests invalid range causing panic
        #[test]
        #[should_panic(expected = "assertion failed: index < len")]
        fn test_dynamic_index_range_panic() {
            use super::*;
            let mut list = List::new();
            let item1 = Item::new("name1", "text1");
            list.add_item(item1);
            list.remove_item(0);
            list.remove_item(0);
        }
    }
}