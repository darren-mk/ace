#[cfg(test)]
mod tests_is_empty {
    fn is_empty(s: &str) -> bool {
	s.len() == 0 }
    #[test]
    fn t_empty_string() {
        assert_eq!(is_empty(""), true);}
    #[test]
    fn t_nonempty_string() {
        assert_eq!(is_empty("hi"), false);}
    #[test]
    fn t_space_is_not_empty() {
        assert_eq!(is_empty(" "), false);}
}
