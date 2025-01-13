#[cfg(test)]
mod tests {
    #[test]
    fn test_struct() {
        struct User {
            is_active: bool,
            username: String,
            employer: Option<String>, }
        let darren = User {
            is_active: true,
            username: String::from("darrenkim"),
            employer: None, };
        assert!(darren.is_active);
        assert_eq!("darrenkim", darren.username);
        assert_eq!(None, darren.employer); }
    #[test]
    fn test_tuple_struct() {
        struct Point(i32, i32, i32);
        let x = Point(1, 3, 2);
        assert_eq!(1, x.0);
        assert_eq!(3, x.1);
        assert_eq!(2, x.2); }
}
