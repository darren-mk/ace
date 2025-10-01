#[cfg(test)]
mod test_format {
    #[test]
    fn basics() {
        let s1 = String::from("tic");
        let s2 = String::from("tac");
        let s3 = String::from("toe");
        let s = format!("{s1}-{s2}-{s3}"); 
        // format! uses reference
        assert_eq!("tic-tac-toe", s);
        assert_eq!("tic", s1);
        assert_eq!("tac", s2);
        assert_eq!("toe", s3);
    }
}
