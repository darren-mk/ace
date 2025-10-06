#[cfg(test)]
mod learn_iter {
    #[test]
    fn in_for_loop() {
        let mut acc = 0;
        for v in vec![1, 2, 3].iter() {
            acc = acc + v;}
        assert_eq!(6, acc);}
    #[test]
    fn by_next() {
        let v = vec![1, 2, 3];
        let mut it = v.iter();
        assert_eq!(Some(&1), it.next());
        assert_eq!(Some(&2), it.next());
        assert_eq!(Some(&3), it.next());
        assert_eq!(None, it.next());}}
