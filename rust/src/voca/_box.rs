#[cfg(test)]
mod learn_box {
    #[test]
    fn basics() {
        let x = 1;
        let y = Box::new(x);
        assert_eq!(1, x);
        assert_eq!(1, *y);}}
