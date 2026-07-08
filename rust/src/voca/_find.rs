#[cfg(test)]
mod tests_find {
    fn starts_with(s: &str, prefix: &str) -> bool {
	let sl: usize = s.len();
	let pl: usize = prefix.len();
	if sl < pl { return false }
	s[..pl] == prefix[..pl] }
    fn find(haystack: &str, needle: &str) -> Option<usize> {
	let hl: usize = haystack.len();
	let nl: usize = needle.len();
	if hl < nl { return None }
	for i in 0..(hl - nl + 1) {
	    if starts_with(&haystack[i..], needle) {
		return Some(i) } }
	return None }
    #[test]
    fn t_found_at_start() {
        assert_eq!(find("hello world", "hello"), Some(0));}
    #[test]
    fn t_found_at_middle() {
        assert_eq!(find("hello world", "lo w"), Some(3));}
    #[test]
    fn t_found_at_end() {
        assert_eq!(find("hello world", "world"), Some(6));}
    #[test]
    fn t_not_found() {
        assert_eq!(find("hello world", "xyz"), None);}
    #[test]
    fn t_empty_needle() {
        assert_eq!(find("hello", ""), Some(0));}
    #[test]
    fn t_needle_longer_than_haystack() {
        assert_eq!(find("hi", "hello"), None);}
    #[test]
    fn t_exact_match() {
        assert_eq!(find("abc", "abc"), Some(0));}
    #[test]
    fn t_returns_first_occurrence() {
        assert_eq!(find("abcabc", "bc"), Some(1));}
}
