#[cfg(test)]
mod tests_repeat {
    fn repeat(s: &str, n: usize) -> String {
	let mut result = String::new();
	for _ in 0..n { result.push_str(s); }
	result }
    #[test]
    fn t_basic() {
        assert_eq!(repeat("ha", 3), "hahaha");}
    #[test]
    fn t_single() {
        assert_eq!(repeat("abc", 1), "abc");}
    #[test]
    fn t_zero() {
        assert_eq!(repeat("abc", 0), "");}
    #[test]
    fn t_single_char() {
        assert_eq!(repeat("x", 5), "xxxxx");}
    #[test]
    fn t_empty_string() {
        assert_eq!(repeat("", 3), "");}
}
