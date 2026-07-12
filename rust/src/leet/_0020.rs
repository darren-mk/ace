struct Solution;

impl Solution {
    pub fn is_valid(s: String) -> bool {
	let mut stack: Vec<char> = vec![];
	for c in s.chars() {
	    if stack.last() == Some(&'(') && c == ')' { stack.pop(); }
	    else if stack.last() == Some(&'[') && c == ']' { stack.pop(); }
	    else if stack.last() == Some(&'{') && c == '}' { stack.pop(); }
	    else { stack.push(c);} }
	stack.is_empty() } }

#[cfg(test)]
mod a {
    use super::Solution;
    #[test]
    fn t() {
        assert_eq!(Solution::is_valid("()".to_string()), true);
        assert_eq!(Solution::is_valid("()[]{}".to_string()), true);
        assert_eq!(Solution::is_valid("(]".to_string()), false);
        assert_eq!(Solution::is_valid("([)]".to_string()), false);
        assert_eq!(Solution::is_valid("{[]}".to_string()), true);
        assert_eq!(Solution::is_valid("".to_string()), true);
        assert_eq!(Solution::is_valid("(".to_string()), false);
        assert_eq!(Solution::is_valid(")".to_string()), false);
        assert_eq!(Solution::is_valid("((()))".to_string()), true);
    }
}
