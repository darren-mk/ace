fn proc() -> i32 {
    let x = 1;
    x + 100
}

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn test_add() {
        assert_eq!(101, proc());
    }
}
