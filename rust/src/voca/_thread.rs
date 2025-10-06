#[cfg(test)]
mod learn_thread {
    #[test]
    fn spawn() {
        let mut acc = Vec::new();
        let h = std::thread::spawn(move || {
            for i in 1..10 {
                acc.push(i);}});
        h.join().unwrap();
        assert_eq!(1, 1);}}
