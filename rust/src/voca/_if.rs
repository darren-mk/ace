#[cfg(test)]
mod if_tests {
    #[test]
    fn basic() {
        let cond = true;
        let n = if cond {1} else {2};
        assert_eq!(1, n);}
    #[test]
    fn elseif() {
        let k = 2;
        let n = if k == 1 {11} else if k == 2 {22} else {33};
        assert_eq!(22, n);}}
