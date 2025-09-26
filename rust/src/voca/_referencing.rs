#[cfg(test)]
mod referencing_tests {
    #[test] fn basics() {
        let s1: String = String::from("yo");
        let p1: &String = &s1;
        assert_eq!(p1, p1);
        assert_eq!(s1, *p1);
    }

    fn str_length(s: &str) -> usize {
        // sp is consumed as if it's a string,
        // but it's a reference.
        s.len()
    }
    #[test] fn pass_ref_to_fn() {
        let s: String = String::from("hey");
        assert_eq!("hey", s);
        assert_eq!(3, s.len());
        assert_eq!(3, str_length(&s));
        assert_eq!("hey", s);
        assert_eq!(3, s.len());
    }

    fn change_borrowed(s: &mut String) {
        s.push_str("!");
    }
    #[test] fn mutable_reference() {
        let mut s = String::from("hola");
        assert_eq!("hola", s);
        // &mut s is called "mutable reference"
        change_borrowed(&mut s);
        assert_eq!("hola!", s);
    }
    
}
