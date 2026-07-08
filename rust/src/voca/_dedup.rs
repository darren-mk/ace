#[cfg(test)]
mod tests_dedup {
    fn dedup(v: &[i32]) -> Vec<i32> {
	let mut result: Vec<i32> = vec![];
	for x in v {
	    match result.last() {
		Some(y) => if *x != *y { result.push(*x) }
		None => result.push(*x)}}
	result}
    #[test]
    fn t_basic() {
        assert_eq!(dedup(&[1, 1, 2, 3, 3, 3, 4]), vec![1, 2, 3, 4]);}
    #[test]
    fn t_no_dupes() {
        assert_eq!(dedup(&[1, 2, 3]), vec![1, 2, 3]);}
    #[test]
    fn t_all_same() {
        assert_eq!(dedup(&[5, 5, 5, 5]), vec![5]);}
    #[test]
    fn t_empty() {
        assert_eq!(dedup(&[]), vec![]);}
    #[test]
    fn t_single() {
        assert_eq!(dedup(&[7]), vec![7]);}
    #[test]
    fn t_non_consecutive_dupes_kept() {
        assert_eq!(dedup(&[1, 2, 1, 2]), vec![1, 2, 1, 2]);}
}
