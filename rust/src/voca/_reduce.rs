#[cfg(test)]
mod tests_reduce {
    fn reduce(v: &[i32], init: i32, f: fn(i32, i32) -> i32) -> i32 {
	let mut result: i32 = init;
	for x in v {result = f(result, *x);}
	result}
    #[test]
    fn t_sum() {
        assert_eq!(reduce(&[1, 2, 3, 4, 5], 0, |acc, x| acc + x), 15);}
    #[test]
    fn t_product() {
        assert_eq!(reduce(&[1, 2, 3, 4], 1, |acc, x| acc * x), 24);}
    #[test]
    fn t_max() {
        assert_eq!(reduce(&[3, 1, 4, 1, 5], i32::MIN, |acc, x| if x > acc { x } else { acc }), 5);}
    #[test]
    fn t_min() {
        assert_eq!(reduce(&[3, 1, 4, 1, 5], i32::MAX, |acc, x| if x < acc { x } else { acc }), 1);}
    #[test]
    fn t_empty() {
        assert_eq!(reduce(&[], 0, |acc, x| acc + x), 0);}
    #[test]
    fn t_count() {
        assert_eq!(reduce(&[10, 20, 30], 0, |acc, _| acc + 1), 3);}
    #[test]
    fn t_string_len_sum() {
        assert_eq!(reduce(&[3, 5, 2], 100, |acc, x| acc + x), 110);}
}
