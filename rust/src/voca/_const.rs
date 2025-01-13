const PI : f32 = 3.14;

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn test_add() {
        assert_eq!(3.14, PI);
    }
}
