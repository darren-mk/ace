#[cfg(test)]
mod tests_starts_with {
    fn starts_with(s: &str, prefix: &str) -> bool {
	let sl: usize = s.len();
	let pl: usize = prefix.len();
	if sl < pl { return false }
	s[..pl] == prefix[..pl] }
    #[test]
    fn t_true() {
        assert_eq!(starts_with("hello world", "hello"), true);}
    #[test]
    fn t_false() {
        assert_eq!(starts_with("hello world", "world"), false);}
    #[test]
    fn t_empty_prefix() {
        assert_eq!(starts_with("hello", ""), true);}
    #[test]
    fn t_prefix_longer_than_s() {
        assert_eq!(starts_with("hi", "hello"), false);}
    #[test]
    fn t_exact_match() {
        assert_eq!(starts_with("abc", "abc"), true);}
    #[test]
    fn t_single_char() {
        assert_eq!(starts_with("abc", "a"), true);
        assert_eq!(starts_with("abc", "b"), false);}
}
