#[cfg(test)]
mod test_generic {
    #[test]
    fn generics_on_sequence() {
        fn first_item<T>(l: &[T]) -> &T {
            &l[0]}
        assert_eq!(&10, first_item(&vec![10, 20, 30]));}
    #[test]
    fn generics_on_struct() {
        struct Point<T> { x: T, y: T }
        let i = Point { x: 12, y: 34 };
        let f = Point { x: 1.23, y: 2.34 };
        let s = Point { x: "a", y: "b" };
        assert_eq!(12, i.x);
        assert_eq!(34, i.y);
        assert_eq!(1.23, f.x);
        assert_eq!(2.34, f.y);
        assert_eq!("a", s.x);
        assert_eq!("b", s.y);}}
