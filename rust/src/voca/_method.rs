#[cfg(test)]
mod method_tests {
    struct Rectangle {
        width: u32,
        height: u32,
    }
    impl Rectangle {
        fn area(&self) -> u32 {
            self.width * self.height
        }
        fn can_hold(&self, other: &Rectangle) -> bool {
            self.width > other.width && self.height > other.height
        }
    }
    #[test]
    fn basics() {
        let r1 = Rectangle {
            width: 2,
            height: 3,
        };
        assert_eq!(6, r1.area());
    }
    #[test]
    fn take_other_arg() {
        let r1 = Rectangle {
            width: 3,
            height: 5,
        };
        let r2 = Rectangle {
            width: 2,
            height: 3,
        };
        assert!(r1.can_hold(&r2));
        assert!(!r2.can_hold(&r1));
    }
}
