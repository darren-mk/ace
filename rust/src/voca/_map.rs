#[cfg(test)]
mod tests_map {
    fn map(v: &[i32], f: fn(i32) -> i32) -> Vec<i32> {
	let mut result: Vec<i32> = vec![];
	for x in v {
	    result.push(f(*x));}
	result}
    #[test]
    fn t_double() {
        assert_eq!(map(&[1, 2, 3], |x| x * 2), vec![2, 4, 6]);}
    #[test]
    fn t_square() {
        assert_eq!(map(&[1, 2, 3, 4], |x| x * x), vec![1, 4, 9, 16]);}
    #[test]
    fn t_negate() {
        assert_eq!(map(&[1, -2, 3], |x| -x), vec![-1, 2, -3]);}
    #[test]
    fn t_add_one() {
        assert_eq!(map(&[10, 20, 30], |x| x + 1), vec![11, 21, 31]);}
    #[test]
    fn t_empty() {
        assert_eq!(map(&[], |x| x * 2), vec![]);}
    #[test]
    fn t_identity() {
        assert_eq!(map(&[5, 10, 15], |x| x), vec![5, 10, 15]);}
}
