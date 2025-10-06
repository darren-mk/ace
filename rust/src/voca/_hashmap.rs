#[cfg(test)]
mod test_hashmap {
    use std::collections::HashMap;
    #[test]
    fn in_mut() {
        let mut scores = HashMap::new();
        scores.insert(1, 98);
        scores.insert(2, 67);
        assert_eq!(Some(&98), scores.get(&1));
        assert_eq!(Some(&67), scores.get(&2));}}
