#[cfg(test)]
mod tests_sum {
    fn sum(v: &[i32]) -> i32 {
	let mut result = 0;
	for x in v {result += *x;}
	result}
    #[test]
    fn t_basic() {
        assert_eq!(sum(&[1, 2, 3, 4, 5]), 15);}
    #[test]
    fn t_single() {
        assert_eq!(sum(&[42]), 42);}
    #[test]
    fn t_empty() {
        assert_eq!(sum(&[]), 0);}
    #[test]
    fn t_negatives() {
        assert_eq!(sum(&[-1, -2, -3]), -6);}
    #[test]
    fn t_mixed() {
        assert_eq!(sum(&[-5, 5, -10, 10]), 0);}
}
