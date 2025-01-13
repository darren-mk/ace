#[cfg(test)]
mod tests {
    #[test]
    fn test_mut() {
        let mut s = String::from("hello");
        s.push_str(", world!");
        let a = &s;
        assert_eq!("hello, world!", s);
        assert_eq!("hello, world!", a);
    }
}




