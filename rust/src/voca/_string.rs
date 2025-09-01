#[cfg(test)]
mod string_tests {
    #[test]
    fn mutable_string() {
        let mut s = String::from("yo");
        s.push_str(", bro!");
        assert_eq!("yo, bro!", s);}}
