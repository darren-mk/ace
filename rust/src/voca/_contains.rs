#[cfg(test)]
mod tests_contains {
    fn starts_with(s: &str, prefix: &str) -> bool {
	let sl: usize = s.len();
	let pl: usize = prefix.len();
	if sl < pl { return false }
	s[..pl] == prefix[..pl] }
    fn contains(haystack: &str, needle: &str) -> bool {
	let hl: usize = haystack.len();
	let nl: usize = needle.len();
	if hl < nl { return false }
	for i in 0..(hl - nl + 1) {
	    if starts_with(&haystack[i..], needle) { return true }}
	false }
    #[test]
    fn t_found() {
        assert_eq!(contains("hello world", "world"), true);}
    #[test]
    fn t_not_found() {
        assert_eq!(contains("hello world", "xyz"), false);}
    #[test]
    fn t_empty_needle() {
        assert_eq!(contains("hello", ""), true);}
    #[test]
    fn t_needle_longer_than_haystack() {
        assert_eq!(contains("hi", "hello"), false);}
    #[test]
    fn t_exact_match() {
        assert_eq!(contains("abc", "abc"), true);}
    #[test]
    fn t_at_start() {
        assert_eq!(contains("hello world", "hello"), true);}
    #[test]
    fn t_at_end() {
        assert_eq!(contains("hello world", "orld"), true);}
}
