#[cfg(test)]
mod tests_reverse {
    fn reverse(v: &mut [i32]) {
	let l = v.len();
	let mut a;
	let mut b;
	for i in 0..(l/2) {
	    a = v[i];
	    b = v[l-i-1];
	    v[i] = b;
	    v[l-i-1] = a;}}
    #[test]
    fn t_basic() {
        let mut v = vec![1, 2, 3, 4, 5];
        reverse(&mut v);
        assert_eq!(v, vec![5, 4, 3, 2, 1]);}
    #[test]
    fn t_single() {
        let mut v = vec![1];
        reverse(&mut v);
        assert_eq!(v, vec![1]);}
    #[test]
    fn t_empty() {
        let mut v: Vec<i32> = vec![];
        reverse(&mut v);
        assert_eq!(v, vec![]);}
    #[test]
    fn t_two() {
        let mut v = vec![1, 2];
        reverse(&mut v);
        assert_eq!(v, vec![2, 1]);}
    #[test]
    fn t_even_length() {
        let mut v = vec![1, 2, 3, 4];
        reverse(&mut v);
        assert_eq!(v, vec![4, 3, 2, 1]);}
}
