#[cfg(test)]
mod tests_max {
    fn max(v: &[i32]) -> Option<i32> {
	let mut m: Option<i32> = None;
	for x in v {
	    match m {
		Some(v) => if v < *x { m = Some(*x)},
		None => m = Some(*x) } }
	return m }
    #[test]
    fn t_basic() {
        assert_eq!(max(&[3, 1, 4, 1, 5]), Some(5));}
    #[test]
    fn t_single() {
        assert_eq!(max(&[42]), Some(42));}
    #[test]
    fn t_empty() {
        assert_eq!(max(&[]), None);}
    #[test]
    fn t_negatives() {
        assert_eq!(max(&[-3, -1, -7, -2]), Some(-1));}
    #[test]
    fn t_mixed() {
        assert_eq!(max(&[-5, 0, 5, 10]), Some(10));}
    #[test]
    fn t_all_same() {
        assert_eq!(max(&[3, 3, 3]), Some(3));}
}
