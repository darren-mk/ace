#[cfg(test)]
mod test_enum {
    #[test]
    fn basics() {
        #[derive(PartialEq, Debug)]
        enum Fruit {
            Apple,
            Orange,
        }
        let mine = Fruit::Orange;
        let yours = Fruit::Apple;
        assert_eq!(Fruit::Orange, mine);
        assert_eq!(Fruit::Apple, yours);
    }
    #[test]
    fn enum_taking_values() {
        #[derive(PartialEq, Debug)]
        enum Love {
            Platonic(String),
            Erotic(String),
        }
        let jane = Love::Platonic(String::from("Jane Eyre"));
        let aema = Love::Erotic(String::from("Aema"));
        assert_eq!(Love::Platonic(String::from("Jane Eyre")), jane);
        assert_eq!(Love::Erotic(String::from("Aema")), aema);
    }
    #[test]
    fn take_values_of_different_types() {
        #[derive(PartialEq, Debug)]
        enum Message {
            Quit,
            Move { x: i32, y: i32 },
            Write(String),
            ChangeColor(i32, i32, i32),
        }
        let q = Message::Quit;
        let m = Message::Move { x: 12, y: 23 };
        let w = Message::Write(String::from("yo"));
        let c = Message::ChangeColor(4, 5, 6);
        assert_eq!(q, q);
        assert_eq!(m, m);
        assert_eq!(w, w);
        assert_eq!(c, c);
    }
}
