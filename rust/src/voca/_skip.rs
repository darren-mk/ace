#[cfg(test)]
mod tests_skip {
    fn skip(v: &[i32], n: usize) -> Vec<i32> {
	let l = std::cmp::min(v.len(), n);
	v[l..].to_vec()}
    #[test]
    fn t_basic() {
        assert_eq!(skip(&[1, 2, 3, 4, 5], 2), vec![3, 4, 5]);}
    #[test]
    fn t_zero() {
        assert_eq!(skip(&[1, 2, 3], 0), vec![1, 2, 3]);}
    #[test]
    fn t_more_than_len() {
        assert_eq!(skip(&[1, 2], 5), vec![]);}
    #[test]
    fn t_exact_len() {
        assert_eq!(skip(&[1, 2, 3], 3), vec![]);}
    #[test]
    fn t_empty() {
        assert_eq!(skip(&[], 3), vec![]);}
    #[test]
    fn t_one() {
        assert_eq!(skip(&[10, 20, 30], 1), vec![20, 30]);}
}
