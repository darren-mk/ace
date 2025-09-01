#[cfg(test)]
mod tests {
    #[test]
    fn declaration() {
        let tup: (i32, String) = (12, "yay".to_string());
        assert_eq!(12, tup.0);
        assert_eq!("yay", tup.1);
        let (a, b) = tup;
        assert_eq!(12, a);
        assert_eq!("yay", b);}}
