struct Solution;

impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
	let mut w: usize = 0;
	for i in 0..nums.len() {
	    if w < i {
		if nums[w] != nums[i] {
		    w += 1;
		    nums[w] = nums[i]; } } }
	(w as i32) + 1 } }

/*
0 0: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
0 1: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
0 2: [0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
1 3: [0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
1 4: [0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
*/

#[cfg(test)]
mod a {
    use super::Solution;
    #[test]
    fn t() {
        let mut v1 = vec![1, 1, 2];
        assert_eq!(Solution::remove_duplicates(&mut v1), 2);
        assert_eq!(&v1[..2], &[1, 2]);
	
        let mut v2 = vec![0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
        assert_eq!(Solution::remove_duplicates(&mut v2), 5);
        assert_eq!(&v2[..5], &[0, 1, 2, 3, 4]);

        let mut v3 = vec![1];
        assert_eq!(Solution::remove_duplicates(&mut v3), 1);
        assert_eq!(&v3[..1], &[1]);

        let mut v4 = vec![1, 2, 3];
        assert_eq!(Solution::remove_duplicates(&mut v4), 3);
        assert_eq!(&v4[..3], &[1, 2, 3]);
    }
}
