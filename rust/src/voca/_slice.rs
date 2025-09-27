#[cfg(test)]
mod slice_tests {
    #[test]
    fn basic() {
        let s = String::from("Darren Kim");
        let slice1: &str = &s[..6];
        let slice2: &str = &s[7..];
        assert_eq!("Darren", slice1);
        assert_eq!("Kim", slice2);
    }
    fn first_three_chars(s: &String) -> &str {
        &s[..3]
    }
    #[test]
    fn pass_slice() {
        let s = String::from("Darren Kim");
        let v = first_three_chars(&s);
        assert_eq!("Dar", v);
    }
}
