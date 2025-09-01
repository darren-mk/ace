#[cfg(test)]
mod ownership_tests {
    #[test]
    fn moving() {
        let s1 = String::from("yo");
        assert_eq!("yo", s1);
        let s2 = s1;
        assert_eq!("yo", s2);}
    #[test]
    fn copy_on_stack() {
        let x = 3;
        let y = x;
        assert_eq!(3, x);
        assert_eq!(3, y);}
    #[test]
    fn pass_and_return() {
        let s = String::from("yo");
        let p1 = s.as_ptr();
        let (z, p3) = just_pass(s, p1);
        assert_eq!("yo", z);
        assert_eq!(p1, p3);}
    fn just_pass(s: String, p1: *const u8) -> (String, *const u8) {
        assert_eq!("yo", s);
        let p2 = s.as_ptr();
        assert_eq!(p1, p2);
        (s, p2) }}
