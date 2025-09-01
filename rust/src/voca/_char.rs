#[cfg(test)]
mod tests {
    #[test]
    fn with_type_annotation() {
        let c : char = 'a';
        assert_eq!('a', c);}
    #[test]
    fn without_type_annotation() {
        let c = 'a';
        assert_eq!('a', c);}}
