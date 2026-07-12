struct Solution;

impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
	let hl: usize = haystack.len();
	let nl: usize = needle.len();
	if hl < nl { return -1 }
	for i in 0..(hl - nl + 1) {
	    if needle == haystack[i..(i + nl)] {
		return i as i32 } }
	return -1 } }

#[cfg(test)]
mod a {
    use super::Solution;
    #[test]
    fn t() {
        assert_eq!(Solution::str_str("sadbutsad".to_string(), "sad".to_string()), 0);
        assert_eq!(Solution::str_str("leetcode".to_string(), "leeto".to_string()), -1);
        assert_eq!(Solution::str_str("hello".to_string(), "ll".to_string()), 2);
        assert_eq!(Solution::str_str("a".to_string(), "a".to_string()), 0);
        assert_eq!(Solution::str_str("abc".to_string(), "c".to_string()), 2);
        assert_eq!(Solution::str_str("abc".to_string(), "d".to_string()), -1); } }
