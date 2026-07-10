#[cfg(test)]
mod tests_any {
    fn any(v: &[i32], f: fn(i32) -> bool) -> bool {
	for x in v {
	    if f(*x) { return true } }
	return false }
    #[test]
    fn t_found() {
        assert_eq!(any(&[1, 2, 3, 4], |x| x > 3), true);}
    #[test]
    fn t_not_found() {
        assert_eq!(any(&[1, 2, 3], |x| x > 10), false);}
    #[test]
    fn t_all_match() {
        assert_eq!(any(&[2, 4, 6], |x| x % 2 == 0), true);}
    #[test]
    fn t_empty() {
        assert_eq!(any(&[], |x| x > 0), false);}
    #[test]
    fn t_first_matches() {
        assert_eq!(any(&[10, 1, 2], |x| x > 5), true);}
}
