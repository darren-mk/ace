#[cfg(test)]
mod tests_zip {
    fn zip(a: &[i32], b: &[i32]) -> Vec<(i32, i32)> {
	let l: usize = std::cmp::min(a.len(), b.len());
	let mut result: Vec<(i32, i32)> = vec![];
	for i in 0..l {
	    result.push((a[i], b[i]));}
	result }
    #[test]
    fn t_basic() {
        assert_eq!(zip(&[1, 2, 3], &[4, 5, 6]), vec![(1,4), (2,5), (3,6)]);}
    #[test]
    fn t_different_lengths() {
        assert_eq!(zip(&[1, 2, 3], &[4, 5]), vec![(1,4), (2,5)]);}
    #[test]
    fn t_first_shorter() {
        assert_eq!(zip(&[1], &[4, 5, 6]), vec![(1,4)]);}
    #[test]
    fn t_empty_first() {
        assert_eq!(zip(&[], &[1, 2]), vec![]);}
    #[test]
    fn t_empty_second() {
        assert_eq!(zip(&[1, 2], &[]), vec![]);}
    #[test]
    fn t_both_empty() {
        assert_eq!(zip(&[], &[]), vec![]);}
    #[test]
    fn t_single() {
        assert_eq!(zip(&[1], &[2]), vec![(1,2)]);}
}
