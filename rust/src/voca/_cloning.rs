#[cfg(test)]
mod cloning_tests {
    #[test]
    fn cloning() {
        let s1 = String::from("yo");
        assert_eq!("yo", s1);
        let s2 = s1.clone();
        assert_eq!("yo", s2);
        assert_eq!("yo", s1);
        let s3 = s1;
        assert_eq!("yo", s2);
        assert_eq!("yo", s3);}}
