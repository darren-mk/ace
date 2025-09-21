#[cfg(test)]
mod referencing_tests {
    #[test]
    fn basics() {
        let s1: String = String::from("yo");
        println!("{:?}", s1);
        let p1: &String = &s1;
        println!("{:p}", p1);
        assert_eq!(p1, p1);
        assert_eq!(s1, *p1);
    }
    fn str_length(sp: &str) -> usize {
        sp.len()
    }
    #[test]
    fn pass_ref_to_fn() {
        let s: String = String::from("hey");
        assert_eq!(3, s.len());
        assert_eq!(3, str_length(&s));
    }
}
