#[cfg(test)]
mod array_tests {
    #[test]
    fn array() {
        let nums : [i32; 3] = [1, 2, 3];
        assert_eq!([1, 2, 3], nums);
        assert_eq!(1, nums[0]);
        assert_eq!(2, nums[1]);}
    #[test]
    fn repetitive() {
        let sevens = [7; 3];
        assert_eq!([7, 7, 7], sevens);}}
