#[cfg(test)]
mod learn_deref {
    #[test]
    fn basics() {
        let x = 1;
        let y = &x;
        assert_eq!(1, x);
        assert_eq!(&1, y);
        assert_eq!(1, *y);}}
