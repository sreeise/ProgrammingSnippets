
/*
Given a sorted array nums, remove the duplicates in-place such that each element
appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the
input array in-place with O(1) extra memory.
*/

pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
    if nums.len() == 0 {
        return 0;
    }

    let mut count = 0;
    loop {
        let temp = count;
        while temp + 1 < nums.len() && nums[temp] == nums[temp + 1] {
            nums.remove(temp);
        }

        if count + 1 >= nums.len() {
            break;
        }

        count += 1;
    }
    return nums.len() as i32;
}


#[test]
fn duplicates_test() {
    let mut vec = vec![0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
    let length = remove_duplicates(&mut vec);
    assert_eq!(length, 5);
    assert_eq!(vec, vec![0, 1, 2, 3, 4]);
}
