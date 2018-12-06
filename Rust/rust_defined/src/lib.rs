#![allow(dead_code)] // Allow dead code across entire crate

#[macro_use]
extern crate serde_derive;

mod json_write;

/*
Vec and dynamically resized data structures

Shows using different methods for Vec as well as
common traits.
*/
mod dynamic_resize {
    #[derive(Debug)]
    pub struct List<T> {
        pub length: usize,
        pub vec_list: Vec<T>,
    }

    impl<T> List<T> {
        fn new() -> List<T> {
            List {
                length: 0,
                vec_list: Vec::new(),
            }
        }

        fn length(&self) -> usize {
            self.vec_list.len()
        }

        fn add_item(&mut self, item: T, ) {
            self.vec_list.push(item);
            self.update_length();
        }

        fn remove_item(&mut self, index: usize) {
            self.vec_list.remove(index);
            self.update_length();
        }

        fn update_length(&mut self) {
            self.length = self.length();
        }

        /// Merges given Vec<Item> into self Vec<Item>
        fn merge(&mut self, vec_array_list: Vec<T>) {
            self.vec_list.extend(vec_array_list.into_iter());
        }

        fn clear(&mut self) {
            self.vec_list.clear();
        }
    }

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

    /*
    Structs can implement traits Copy and Clone
    if all of their items are able to implement
    copy and clone
    */
    #[derive(Debug, Copy, Clone)]
    struct ItemCopy {
        int_num: u32,
        dec_num: f64,
    }

    impl ItemCopy {
        fn set_int_num(&mut self, int_num: u32) {
            self.int_num = int_num;
        }
        fn set_dec_num(&mut self, dec_num: f64) {
            self.dec_num = dec_num;
        }
    }

    /*
    PartialEq takes one method: eq()

    Here eq() allows creating a method for testing whether
    two items of the same type are equal.
    */
    impl PartialEq for ItemCopy {
        fn eq(&self, item: &ItemCopy) -> bool {
            self.int_num == item.int_num &&
                self.dec_num == item.dec_num
        }
    }

    impl List<ItemCopy> {
        fn set_items(&mut self, int_num: u32, dec_num: f64, index: usize) {
            self.vec_list[index].set_int_num(int_num);
            self.vec_list[index].set_dec_num(dec_num);
        }
    }

    #[cfg(test)]
    mod tests {
        use super::*;

        // Tests the Item methods
        #[test]
        fn test_dynamic_item_create() {
            let item = Item::new("name", "text");
            assert_eq!(item.name_of(), "name");
            assert_eq!(item.text_of(), "text");
        }

        // Test that the length is updated on List after add and remove item
        #[test]
        fn test_dynamic_update_length() {
            let mut list = List::<Item>::new();
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
            let mut list = List::<Item>::new();
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
            let mut list = List::<Item>::new();
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
            let mut list = List::<Item>::new();
            let item1 = Item::new("name1", "text1");
            list.add_item(item1);
            list.remove_item(0);
            list.remove_item(0);
        }

        #[test]
        fn test_dynamic_clear() {
            let mut list = List::<Item>::new();
            let item1 = Item::new("name1", "text1");
            let item2 = Item::new("name2", "text2");

            list.add_item(item1);
            list.add_item(item2);
            assert_eq!(list.length(), 2);
            list.clear();
            assert_eq!(list.length(), 0);
        }


        #[test]
        fn test_copy() {
            let mut list = List::<ItemCopy>::new();
            let item = ItemCopy {
                int_num: 32,
                dec_num: 12.0,
            };

            let item2 = item.clone();
            list.add_item(item);
            list.add_item(item2);
            assert_eq!(list.length(), 2);
        }

        #[test]
        fn test_item_partial_eq() {
            let mut list = List::<ItemCopy>::new();
            let item = ItemCopy {
                int_num: 32,
                dec_num: 12.0,
            };

            let item2 = ItemCopy {
                int_num: 22,
                dec_num: 22.23,
            };

            assert_ne!(item, item2);
            list.add_item(item);
            list.add_item(item2);
            assert_eq!(list.length(), 2);

            assert_eq!(list.vec_list[0], item);
            assert_eq!(list.vec_list[1], item2);

            list.remove_item(0);
            assert_eq!(list.vec_list[0], item2);
        }

        #[test]
        fn test_set_items() {
            let mut list = List::<ItemCopy>::new();
            let item = ItemCopy {
                int_num: 32,
                dec_num: 12.0,
            };

            assert_eq!(item.int_num, 32);
            assert_eq!(item.dec_num, 12.0);

            list.add_item(item);
            list.set_items(22, 23.33, 0);
            assert_eq!(list.vec_list[0].int_num, 22);
            assert_eq!(list.vec_list[0].dec_num, 23.33);
        }

        #[test]
        fn test_length_variable() {
            let mut list = List::<ItemCopy>::new();
            let item = ItemCopy {
                int_num: 32,
                dec_num: 12.0,
            };

            let item2 = ItemCopy {
                int_num: 100,
                dec_num: 101.23,
            };

            list.add_item(item);
            assert_eq!(list.length, 1);
            list.add_item(item2);
            assert_eq!(list.length, 2);
            list.remove_item(1);
            assert_eq!(list.length, 1);
            list.remove_item(0);
            assert_eq!(list.length, 0);
        }

        #[test]
        fn test_length_method() {
            let mut list = List::<ItemCopy>::new();
            let item = ItemCopy {
                int_num: 32,
                dec_num: 12.0,
            };
            let item2 = ItemCopy {
                int_num: 10,
                dec_num: 33.32,
            };

            list.add_item(item);
            assert_eq!(list.length(), 1);
            list.add_item(item2);
            assert_eq!(list.length(), 2);
        }
    }
}