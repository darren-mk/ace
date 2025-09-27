#[cfg(test)]
mod test_option {
    #[test]
    fn basic() {
        let maybe_number: Option<i32> = Some(7);
        let maybe_no_number: Option<i32> = None;
        assert_eq!(Some(7), maybe_number);
        assert_eq!(None, maybe_no_number);
    }
}
