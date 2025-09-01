#[cfg(test)]
mod while_tests {
    #[test]
    fn basics() {
        let mut n = 0;
        let mut acc = 0;
        while n < 5 {
            n += 1;
            acc += n;}
        assert_eq!(15, acc);}}
