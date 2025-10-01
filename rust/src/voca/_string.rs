#[cfg(test)]
mod string_tests {
    #[test]
    fn basics() {
        assert_eq!(String::from(""), String::new());
        assert_eq!("abc".to_string(), String::from("abc"));}
    #[test]
    fn mutable_string() {
        let mut s = String::from("yo");
        s.push_str(", bro!");
        assert_eq!("yo, bro!", s);}
    #[test]
    fn concatenate() {
        let s1 = String::from("hi, ");
        let s2 = String::from("you");
        // s1 is moved while s2 is borrowed
        assert_eq!("hi, you", s1 + &s2);
        assert_eq!("you", s2);
    }
    #[test]
    fn indexing() {
        let s = "abc";
        assert_eq!("a", &s[0..1]);
    }
    #[test]
    fn iteration() {
        let mut acc: Vec<char> = Vec::new();
        for c in "abc".chars() {
            acc.push(c);
        }
        assert_eq!(vec!['a', 'b', 'c'], acc);
    }
}
