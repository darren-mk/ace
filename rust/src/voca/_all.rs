#[cfg(test)]
mod tests_all {
    fn all(v: &[i32], f: fn(i32) -> bool) -> bool {
	for x in v {
	    if !f(*x) { return false } }
	return true }
    #[test]
    fn t_true() {
        assert_eq!(all(&[2, 4, 6], |x| x % 2 == 0), true);}
    #[test]
    fn t_false() {
        assert_eq!(all(&[2, 3, 6], |x| x % 2 == 0), false);}
    #[test]
    fn t_empty() {
        assert_eq!(all(&[], |x| x > 0), true);}
    #[test]
    fn t_single_pass() {
        assert_eq!(all(&[5], |x| x > 0), true);}
    #[test]
    fn t_single_fail() {
        assert_eq!(all(&[-1], |x| x > 0), false);}
    #[test]
    fn t_all_negative() {
        assert_eq!(all(&[-1, -2, -3], |x| x < 0), true);}
}
