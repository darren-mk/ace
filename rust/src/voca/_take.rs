#[cfg(test)]
mod tests_take {
    fn take(v: &[i32], n: usize) -> Vec<i32> {
	let l = std::cmp::min(v.len(), n);
	v[..l].to_vec() }
    #[test]
    fn t_basic() {
        assert_eq!(take(&[1, 2, 3, 4, 5], 3), vec![1, 2, 3]);}
    #[test]
    fn t_zero() {
        assert_eq!(take(&[1, 2, 3], 0), vec![]);}
    #[test]
    fn t_more_than_len() {
        assert_eq!(take(&[1, 2], 5), vec![1, 2]);}
    #[test]
    fn t_exact_len() {
        assert_eq!(take(&[1, 2, 3], 3), vec![1, 2, 3]);}
    #[test]
    fn t_empty() {
        assert_eq!(take(&[], 3), vec![]);}
    #[test]
    fn t_one() {
        assert_eq!(take(&[10, 20, 30], 1), vec![10]);}
}
