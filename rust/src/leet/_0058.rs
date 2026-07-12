struct Solution;

impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
	s.trim().split(' ').last().unwrap().len() as i32 } }

#[cfg(test)]
mod a {
    use super::Solution;
    #[test]
    fn t() {
        assert_eq!(Solution::length_of_last_word("Hello World".to_string()), 5);
        assert_eq!(Solution::length_of_last_word("   fly me   to   the moon  ".to_string()), 4);
        assert_eq!(Solution::length_of_last_word("luffy is still joyboy".to_string()), 6);
        assert_eq!(Solution::length_of_last_word("a".to_string()), 1);
        assert_eq!(Solution::length_of_last_word("   a".to_string()), 1);
        assert_eq!(Solution::length_of_last_word("a   ".to_string()), 1);
    }
}
