#[cfg(test)]
mod tests_filter {
    fn filter(v: &[i32], f: fn(i32) -> bool) -> Vec<i32> {
	let mut result: Vec<i32> = vec![];
	for x in v {if f(*x) { result.push(*x)}}
	result }
    #[test]
    fn t_evens() {
        assert_eq!(filter(&[1, 2, 3, 4, 5, 6], |x| x % 2 == 0), vec![2, 4, 6]);}
    #[test]
    fn t_odds() {
        assert_eq!(filter(&[1, 2, 3, 4, 5], |x| x % 2 == 1), vec![1, 3, 5]);}
    #[test]
    fn t_positives() {
        assert_eq!(filter(&[-3, -1, 0, 2, 5], |x| x > 0), vec![2, 5]);}
    #[test]
    fn t_none_match() {
        assert_eq!(filter(&[1, 2, 3], |x| x > 10), vec![]);}
    #[test]
    fn t_all_match() {
        assert_eq!(filter(&[2, 4, 6], |x| x % 2 == 0), vec![2, 4, 6]);}
    #[test]
    fn t_empty() {
        assert_eq!(filter(&[], |x| x > 0), vec![]);}
}
