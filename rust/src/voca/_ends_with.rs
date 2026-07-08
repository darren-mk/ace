#[cfg(test)]
mod tests_ends_with {
    fn ends_with(s: &str, suffix: &str) -> bool {
	let sl = s.len();
	let fl = suffix.len();
	if fl == 0 { return true }
	if sl < fl { return false }
	s[(sl-fl)..] == suffix[..] }
    #[test]
    fn t_true() {
        assert_eq!(ends_with("hello world", "world"), true);}
    #[test]
    fn t_false() {
        assert_eq!(ends_with("hello world", "hello"), false);}
    #[test]
    fn t_empty_suffix() {
        assert_eq!(ends_with("hello", ""), true);}
    #[test]
    fn t_suffix_longer_than_s() {
        assert_eq!(ends_with("hi", "hello"), false);}
    #[test]
    fn t_exact_match() {
        assert_eq!(ends_with("abc", "abc"), true);}
    #[test]
    fn t_single_char() {
        assert_eq!(ends_with("abc", "c"), true);
        assert_eq!(ends_with("abc", "b"), false);}
}
