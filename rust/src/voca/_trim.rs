#[cfg(test)]
mod tests_trim {
    fn trim_start(s: &str) -> &str {
	for (i, c) in (*s).char_indices() {
	    if !c.is_whitespace() {
		return &(*s)[i..];}}
	""}
    fn trim_end(s: &str) -> &str {
	for (i, c) in (*s).char_indices().rev() {
	    if !c.is_whitespace() {
		return &(*s)[..(i + c.len_utf8())];}}
	""}
    fn trim(s: &str) -> &str {
	trim_start(trim_end(s))
    }
    #[test]
    fn t_trim_both() {
        assert_eq!(trim("  hello  "), "hello");}
    #[test]
    fn t_trim_start_only() {
        assert_eq!(trim_start("  hello  "), "hello  ");}
    #[test]
    fn t_trim_end_only() {
        assert_eq!(trim_end("  hello  "), "  hello");}
    #[test]
    fn t_no_whitespace() {
        assert_eq!(trim("hello"), "hello");}
    #[test]
    fn t_all_whitespace() {
        assert_eq!(trim("   "), "");}
    #[test]
    fn t_empty() {
        assert_eq!(trim(""), "");}
    #[test]
    fn t_tabs_and_spaces() {
        assert_eq!(trim("\t hello \t"), "hello");}
    #[test]
    fn t_newlines() {
        assert_eq!(trim("\nhello\n"), "hello");}
}
