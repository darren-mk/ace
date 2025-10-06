#[cfg(test)]
mod learn_map {
    #[test]
    fn from_iter() {
        let v = vec![1, 2, 3];
        let collected =
            v.iter()
            .map(|x| x + 1)
            .collect::<Vec<i32>>();
        assert_eq!(vec![2, 3, 4], collected);}}
