#[cfg(test)]
mod learn_closure {
    #[test]
    fn with_one_arg() {
        fn passer_fn(x: i32) -> i32 {x}
        let passer_closure = | x: i32 | -> i32 {x};
        assert_eq!(1, passer_fn(1));
        assert_eq!(1, passer_closure(1));}
    #[test]
    fn with_no_arg() {
        let always_zero = || { 0 };
        assert_eq!(0, always_zero());}
    #[test]
    fn with_two_args() {
        let add_both = |x, y| { x + y };
        assert_eq!(3, add_both(1, 2));}}
