#[cfg(test)]
mod struct_tests {
    #[test]
    fn test_struct_basics() {
        struct User {
            is_active: bool,
            username: String,
            employer: Option<String>,
        }
        let darren = User {
            is_active: true,
            username: String::from("darrenkim"),
            employer: Some(String::from("bitem")),
        };
        assert!(darren.is_active);
        assert_eq!("darrenkim", darren.username);
        assert_eq!(Some(String::from("bitem")), darren.employer);
    }
    #[test]
    fn test_tuple_struct() {
        struct Point(i32, i32, i32);
        let x = Point(1, 3, 2);
        assert_eq!(1, x.0);
        assert_eq!(3, x.1);
        assert_eq!(2, x.2);
    }
    #[test]
    fn init_from_other_instance() {
        struct Person {
            name: String,
            age: u64,
        }
        let darren = Person {
            name: String::from("Darren"),
            age: 50,
        };
        let kim = Person { age: 49, ..darren };
        assert_eq!("Darren", kim.name);
        assert_eq!(49, kim.age);
        assert_eq!(50, darren.age);
        // assert_eq!("Darren", darren.name); // value moved
    }
    #[test]
    fn init_field_shorthand() {
        struct Rectangle {
            width: u64,
            height: u64,
        }
        fn init_rect(width: u64, height: u64) -> Rectangle {
            Rectangle { width, height }
        }
        let a = init_rect(2, 3);
        assert_eq!(2, a.width);
        assert_eq!(3, a.height);
    }
}
