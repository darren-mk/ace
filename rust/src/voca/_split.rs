#[cfg(test)]
mod tests_split {
    fn split(s: &str, delim: char) -> Vec<String> {
	let mut result: Vec<String> = vec![];
	let mut current = String::new();
	for c in (*s).chars() {
	    if c == delim {
		result.push(current);
		current = String::new();
	    } else {
		current.push(c);}}
	result.push(current);
	result}
    #[test]
    fn t_basic() {
        assert_eq!(split("a,b,c", ','), vec!["a", "b", "c"]);}
    #[test]
    fn t_no_delim() {
        assert_eq!(split("hello", ','), vec!["hello"]);}
    #[test]
    fn t_empty_string() {
        assert_eq!(split("", ','), vec![""]);}
    #[test]
    fn t_delim_at_start() {
        assert_eq!(split(",a,b", ','), vec!["", "a", "b"]);}
    #[test]
    fn t_delim_at_end() {
        assert_eq!(split("a,b,", ','), vec!["a", "b", ""]);}
    #[test]
    fn t_consecutive_delims() {
        assert_eq!(split("a,,b", ','), vec!["a", "", "b"]);}
    #[test]
    fn t_only_delims() {
        assert_eq!(split(",,", ','), vec!["", "", ""]);}
    #[test]
    fn t_space_delim() {
        assert_eq!(split("hello world rust", ' '), vec!["hello", "world", "rust"]);}
}
