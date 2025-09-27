#[cfg(test)]
mod test_match {
    #[test]
    fn basics() {
        enum Coin {
            Penny,
            Nickel,
            Dime,
            Quarter,
        }
        fn value(coin: Coin) -> i32 {
            match coin {
                Coin::Penny => 1,
                Coin::Nickel => 5,
                Coin::Dime => 10,
                Coin::Quarter => 25,
            }
        }
        assert_eq!(1, value(Coin::Penny));
        assert_eq!(5, value(Coin::Nickel));
        assert_eq!(10, value(Coin::Dime));
        assert_eq!(25, value(Coin::Quarter));
    }
}
