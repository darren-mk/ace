#[cfg(test)]
mod function_tests {
    #[test]
    fn basic_return() {
        assert_eq!(5, five());
        assert_eq!(3, plus_one(2));}
    fn five() -> i32 { 5 }
    fn plus_one(x: i32) -> i32 { x + 1 }}
