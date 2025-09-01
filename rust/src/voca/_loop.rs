#[cfg(test)]
mod loop_tests {
    #[test]
    fn basic() {
        let mut counter = 0;
        loop {
            counter += 1;
            if 9 < counter { break }}
        assert_eq!(10, counter);}
    #[test]
    fn loop_returning_value() {
        let mut counter = 0;
        let n =
            loop { counter += 1;
                   if 3 < counter { break 100 } };
        assert_eq!(100, n);}}
