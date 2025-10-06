#[cfg(test)]
mod learn_sum {
    #[test]
    fn from_iter() {
        let v = vec![1, 2, 3];
        assert_eq!(6, v.iter().sum());}}
