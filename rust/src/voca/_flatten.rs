#[cfg(test)]
mod tests_flatten {
    fn flatten(v: &[Vec<i32>]) -> Vec<i32> {
	let mut result = vec![];
	for l in v {
	    for x in l {
		result.push(*x);}}
	result}
    #[test]
    fn t_basic() {
        assert_eq!(flatten(&[vec![1, 2], vec![3], vec![4, 5]]), vec![1, 2, 3, 4, 5]);}
    #[test]
    fn t_empty_outer() {
        assert_eq!(flatten(&[]), vec![]);}
    #[test]
    fn t_empty_inners() {
        assert_eq!(flatten(&[vec![], vec![], vec![]]), vec![]);}
    #[test]
    fn t_mixed_empty() {
        assert_eq!(flatten(&[vec![1], vec![], vec![2, 3]]), vec![1, 2, 3]);}
    #[test]
    fn t_single_vec() {
        assert_eq!(flatten(&[vec![1, 2, 3]]), vec![1, 2, 3]);}
    #[test]
    fn t_single_elements() {
        assert_eq!(flatten(&[vec![1], vec![2], vec![3]]), vec![1, 2, 3]);}
}
