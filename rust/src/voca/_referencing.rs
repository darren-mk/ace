#[cfg(test)]
mod referencing_tests {
    #[test]
    fn basics() {
        let s1: String = String::from("yo");
        let p1: &String = &s1;
        assert_eq!(p1, p1);
        assert_eq!(s1, *p1);}}
