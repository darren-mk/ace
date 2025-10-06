#[cfg(test)]
mod test_match {
    #[test]
    fn basics() {
        fn longest<'a>(x: &'a str, y: &'a str) -> &'a str {
            if x.len() > y.len() { x } else { y }}
        let s1 = "abcd";
        let s2 = "def";
        assert_eq!("abcd", longest(&s1, &s2));}
    #[test]
    fn counter_ex_pass_value() {
        fn lefty<T>(x: T, _y: T) -> T { x }
        let i1 = 1;
        let i2 = 2;
        assert_eq!(1, lefty(i1, i2));
        let s1 = "abc";
        let s2 = "def";
        assert_eq!("abc", lefty(s1, s2));}
    #[test]
    fn similar_ex_pass_refs() {
        fn righty<'a, T: ?Sized> (_x: &'a T, y: &'a T) -> &'a T { y } 
        let s1 = "abc";
        let s2 = "def";
        assert_eq!("def", righty(s1, s2));}}
