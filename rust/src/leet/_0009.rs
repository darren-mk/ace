#[cfg(test)]
mod a {
    pub fn f(x: i32) -> bool {
	if x < 0 { return false }
	if x % 10 == 0 && x != 0 { return false }
	let mut x_alt: i32 = x;
	let mut cursor: i32 = 0;
	while cursor < x_alt {
	    cursor = (cursor * 10) + (x_alt % 10);
	    x_alt = x_alt / 10; }
	cursor == x_alt || cursor / 10 == x_alt }
    #[test]
    fn t() {
        assert_eq!(f(121), true);
        assert_eq!(f(1221), true);
        assert_eq!(f(-121), false);
        assert_eq!(f(10), false);
        assert_eq!(f(0), true);
        assert_eq!(f(5), true);
        assert_eq!(f(11), true);
        assert_eq!(f(123), false);}}
