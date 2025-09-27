#[cfg(test)]
mod test_vector {
    #[test]
    fn basics() {
        let mut v = Vec::new();
        let n = 1 + 2;
        v.push(n);
        v.push(7);
        v.push(11);
        assert_eq!(vec![3, 7, 11], v);
        assert_eq!(7, v[1]);
    }
}
