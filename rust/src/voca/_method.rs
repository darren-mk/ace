#[cfg(test)]
mod tests {
    #[test]
    fn test_method() {
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
}
