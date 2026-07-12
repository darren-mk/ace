struct Solution;

impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
	let map = std::collections::HashMap::from([
	    ('I', 1), ('V', 5), ('X', 10), ('L', 50),
	    ('C', 100), ('D', 500), ('M', 1000)]);
	let mut result = 0;
	let mut prev = 0;
	for c in (*s).chars().rev() {
	    let cur = map[&c];
	    if cur < prev { result -= cur; }
	    else { result += cur; }
	    prev = cur; }
	result } }

#[cfg(test)]
mod a {
    use super::Solution;
    #[test]
    fn t() {
        assert_eq!(Solution::roman_to_int("III".to_string()), 3);
        assert_eq!(Solution::roman_to_int("LVIII".to_string()), 58);
        assert_eq!(Solution::roman_to_int("MCMXCIV".to_string()), 1994);
        assert_eq!(Solution::roman_to_int("IV".to_string()), 4);
        assert_eq!(Solution::roman_to_int("IX".to_string()), 9);
        assert_eq!(Solution::roman_to_int("XL".to_string()), 40);
        assert_eq!(Solution::roman_to_int("XC".to_string()), 90);
        assert_eq!(Solution::roman_to_int("CD".to_string()), 400);
        assert_eq!(Solution::roman_to_int("CM".to_string()), 900);
    }
}
