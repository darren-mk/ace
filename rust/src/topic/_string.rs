#[cfg(test)]
mod test_string {

    // ===== LEVEL 1: String vs &str — what's the difference? =====

    // Q1: &str is a string literal, lives in binary
    #[test]
    fn q01_str_literal() {
        let s: &str = "hello"; // a greeting
        assert_eq!(s, "hello");}

    // Q2: String is heap-allocated, owned
    #[test]
    fn q02_string_owned() {
	// create owned String "hello"
        let s: String = String::from("hello");
        assert_eq!(s, "hello");}

    // Q3: &str from String (borrow)
    #[test]
    fn q03_string_to_str() {
        let owned: String = String::from("hello");
        let borrowed: &str = &owned; // borrow as &str
        assert_eq!(borrowed, "hello");}

    // Q4: String from &str
    #[test]
    fn q04_str_to_string() {
        let s: &str = "hello";
	// convert to String
        let owned: String = String::from(s);
        assert_eq!(owned, "hello");}

    // Q5: multiple ways to create String from &str
    #[test]
    fn q05_many_ways() {
        let a: String = String::from("hi"); // String::from
        let b: String = "hi".to_string(); // .to_string()
        let c: String = "hi".to_owned(); // .to_owned()
        assert_eq!(a, "hi");
        assert_eq!(b, "hi");
        assert_eq!(c, "hi");}

    // Q6: String is mutable, &str is not
    #[test]
    fn q06_mutability() {
        let mut s = String::from("hello");
        s.push_str(" world"); // append " world"
        assert_eq!(s, "hello world");}

    // ===== LEVEL 2: common operations =====

    // Q7: push a single char
    #[test]
    fn q07_push_char() {
        let mut s: String = String::from("hello");
	s.push('!');
        assert_eq!(s, "hello!");}

    // Q8: push_str vs push
    #[test]
    fn q08_push_str() {
        let mut s: String = String::from("foo");
        s.push_str("bar"); // append "bar" using push_str
        s.push('!'); // append '!' using push
        assert_eq!(s, "foobar!");}

    // Q9: string length (bytes vs chars)
    #[test]
    fn q09_len() {
        let ascii: &str = "hello";
        let emoji: &str = "hi👋";
	// byte length
        assert_eq!(ascii.len(), 5);
	// byte length (emoji is 4 bytes)
        assert_eq!(emoji.len(), 6);
	// char count
        assert_eq!(emoji.chars().count(), 3);}

    // Q9a: ascii is 1 byte per char
    #[test]
    fn q09a_ascii_bytes() {
        assert_eq!("a".len(), 1);
        assert_eq!("abc".len(), 3);
        assert_eq!("!".len(), 1);
        assert_eq!("7".len(), 1);}

    // Q9b: korean is 3 bytes per char
    #[test]
    fn q09b_korean_bytes() {
        assert_eq!("가".len(), 3);
        assert_eq!("가나다".len(), 9);
        assert_eq!("가나다".chars().count(), 3);}

    // Q9c: emoji is 4 bytes per char
    #[test]
    fn q09c_emoji_bytes() {
        assert_eq!("👋".len(), 4);
        assert_eq!("👋🎉".len(), 8);
        assert_eq!("👋🎉".chars().count(), 2);}

    // Q9d: mixed — predict both len and char count
    #[test]
    fn q09d_mixed_bytes() {
        assert_eq!("a가👋".len(), 8);
        assert_eq!("a가👋".chars().count(), 3);
        assert_eq!("hello가나".len(), 11);
        assert_eq!("hello가나".chars().count(), 7);}

    // Q10: is_empty
    #[test]
    fn q10_is_empty() {
        let a = "";
        let b = "hi";
        assert_eq!((*a).is_empty(), true);
        assert_eq!((*b).is_empty(), false);}

    // Q11: contains
    #[test]
    fn q11_contains() {
        let s = "hello world";
        assert_eq!((*s).contains("world"), true);
        assert_eq!((*s).contains("xyz"), false);}

    // Q12: starts_with, ends_with
    #[test]
    fn q12_starts_ends() {
        let s = "hello world";
        assert_eq!((*s).starts_with("hello"), true);
        assert_eq!((*s).ends_with("world"), true);
        assert_eq!((*s).starts_with("world"), false);}

    // ===== LEVEL 3: slicing strings =====

    // Q13: string slicing by byte index
    #[test]
    fn q13_slice() {
        let s: &'static str = "hello world";
        let word: &str = &(*s)[..5]; // first 5 chars
        assert_eq!(word, "hello");}

    // Q14: slice from middle
    #[test]
    fn q14_slice_middle() {
        let s: &'static str = "abcdef";
        assert_eq!(&s[2..4], "cd");}

    // Q15: can't index a single char with []
    // this does NOT compile — uncomment, read error, re-comment
    #[test]
    fn q15_no_single_index() {
        let s: &'static str = "hello";
	// error! String/str can't be indexed by integer
        // let c = s[0];
	assert_eq!((*s).chars().nth(0), Some('h'));}

    // Q16: get a single char safely
    #[test]
    fn q16_nth_char() {
        let s: &'static str = "hello";
        let first: Option<char> = (*s).chars().nth(0);
        let third: Option<char> = (*s).chars().nth(2);
        assert_eq!(first, Some('h'));
        assert_eq!(third, Some('l'));}

    // ===== LEVEL 4: iterating strings =====

    // Q17: chars iterator
    #[test]
    fn q17_chars() {
        let s: &'static str = "abc";
        let v: Vec<char> = (*s).chars().collect();
        assert_eq!(v, vec!['a', 'b', 'c']);}

    // Q18: bytes iterator
    #[test]
    fn q18_bytes() {
        let s: &'static str = "abc";
	// collect bytes
        let v: Vec<u8> = (*s).bytes().collect(); 
        assert_eq!(v, vec![97, 98, 99]);}

    // Q19: iterate and transform chars
    #[test]
    fn q19_map_chars() {
        let s: &'static str = "hello";
	// uppercase each char, collect to String
        let upper_by_builtin_fn: String = (*s).to_uppercase();
	let upper_by_custom_fn: String = (*s).chars().map(|c| c.to_ascii_uppercase()).collect();
        assert_eq!(upper_by_builtin_fn, "HELLO");
	assert_eq!(upper_by_custom_fn, "HELLO");}

    // Q20: filter chars
    #[test]
    fn q20_filter_chars() {
        let s: &'static str = "h3ll0 w0rld";
	// keep only alphabetic chars
        let letters: String = (*s).chars().filter(|c| c.is_alphabetic()).collect(); 
        assert_eq!(letters, "hllwrld");}

    // Q21: char_indices
    #[test]
    fn q21_char_indices() {
        let s: &'static str = "abc";
        let v: Vec<(usize, char)> = (*s).char_indices().collect();
        assert_eq!(v, vec![(0,'a'),(1,'b'),(2,'c')]);}

    // ===== LEVEL 5: transforming strings =====

    // Q22: to_uppercase, to_lowercase
    #[test]
    fn q22_case() {
        let s: &'static str = "Hello World";
        assert_eq!((*s).to_uppercase(), "HELLO WORLD");
        assert_eq!((*s).to_lowercase(), "hello world");}

    // Q23: trim whitespace
    #[test]
    fn q23_trim() {
        let s: &'static str = "  hello  ";
        assert_eq!((*s).trim(), "hello");
        assert_eq!((*s).trim_start(), "hello  ");
        assert_eq!((*s).trim_end(), "  hello");}

    // Q24: replace
    #[test]
    fn q24_replace() {
        let s: &'static str = "hello world world";
        assert_eq!((*s).replace("world", "rust"), "hello rust rust");
        assert_eq!((*s).replacen("world", "rust", 1), "hello rust world");}

    // Q25: repeat
    #[test]
    fn q25_repeat() {
        let s: &'static str = "ha";
        assert_eq!((*s).repeat(3), "hahaha");}

    // ===== LEVEL 6: splitting and joining =====

    // Q26: split by delimiter
    #[test]
    fn q26_split() {
        let s: &'static str = "a,b,c";
	let parts: Vec<&str> = (*s).split(',').collect();
	assert_eq!(parts, vec!["a","b","c"]);}

    // Q27: split_whitespace
    #[test]
    fn q27_split_whitespace() {
        let s = "hello   world   rust";
        let words: Vec<&str> = (*s).split_whitespace().collect();
        assert_eq!(words, vec!["hello", "world", "rust"]);}

    // Q28: splitn (limit number of splits)
    #[test]
    fn q28_splitn() {
        let s: &'static str = "a:b:c:d";
        let parts: Vec<&str> = (*s).splitn(3, ':').collect();
	// only 3 parts
        assert_eq!(parts, vec!["a", "b", "c:d"]);}

    // Q29: join / concat
    #[test]
    fn q29_join() {
        let parts: Vec<&str> = vec!["hello", "world"];
        let joined: String = parts.join(" ");
        assert_eq!(joined, "hello world");
        let csv: String = parts.join(",");
        assert_eq!(csv, "hello,world");}

    // ===== LEVEL 7: String and ownership =====

    // Q30: String is moved, not copied
    #[test]
    fn q30_string_move() {
        let s1: String = String::from("hello");
        let s2: String = s1; // s1 is moved
        // assert_eq!(s1, "hello"); // this would NOT compile
        assert_eq!(s2, "hello");}

    // Q31: clone to keep both
    #[test]
    fn q31_clone() {
        let s1: String = String::from("hello");
        let s2 : String = s1.clone(); // clone s1
        assert_eq!(s1, "hello");
        assert_eq!(s2, "hello");}

    // Q32: &str is Copy (it's just a reference)
    #[test]
    fn q32_str_copy() {
        let s1: &str = "hello";
        let s2: &str = s1; // copied, not moved
        assert_eq!(s1, "hello"); // still valid
        assert_eq!(s2, "hello");}

    // Q33: function taking &str (borrows)
    #[test]
    fn q33_fn_borrow_str() {
        fn greet(name: &str) -> String {
	    format!("hello, {}", name)}
        let name: String = String::from("rust");
        let msg: String = greet(&name);
        assert_eq!(msg, "hello, rust");
	// name still valid
        assert_eq!(name, "rust");}

    // Q34: function taking String (consumes)
    #[test]
    fn q34_fn_consume_string() {
        fn shout(s: String) -> String {
            (*s).to_uppercase()}
        let s: String = String::from("hello");
	assert_eq!(s, "hello");
	let loud: String = shout(s);
	// assert_eq!(s, "hello"); // unavailable
	assert_eq!(loud, "HELLO");}

    // ===== LEVEL 8: concatenation and formatting =====

    // Q35: + operator (takes ownership of left)
    #[test]
    fn q35_plus_operator() {
        let s1: String = String::from("hello");
        let s2: String = String::from(" world");
        let s3: String = s1 + &s2; // s1 is moved, s2 is borrowed
	// s1 is no longer usable
	// assert_eq!(s1, "hello");
	assert_eq!(s3, "hello world");
	// s2 still valid
        assert_eq!(s2, " world");}

    // Q36: format! macro (no ownership taken)
    #[test]
    fn q36_format() {
        let s1: String = String::from("hello");
        let s2: String = String::from("world");
        let s3: String = format!("{} {}", s1, s2);
        assert_eq!(s1, "hello");
        assert_eq!(s2, "world");
	assert_eq!(s3, "hello world");}

    // Q37: format with numbers
    #[test]
    fn q37_format_numbers() {
        let name: &'static str = "rust";
        let version: i32 = 2024;
        let s: String = format!("{} {}", name, version);
        assert_eq!(s, "rust 2024");}

    // Q38: build string in a loop
    #[test]
    fn q38_build_loop() {
        let mut s: String = String::new();
        for i in 1..=3 {
            s.push_str(&i.to_string());
            if i < 3 { s.push(','); }}
        assert_eq!(s, "1,2,3");}

    // ===== LEVEL 9: conversions =====

    // Q39: number to string
    #[test]
    fn q39_num_to_string() {
        let n: i32 = 42;
        let s: String = n.to_string();
        assert_eq!(s, "42");}

    // Q40: string to number
    #[test]
    fn q40_string_to_num() {
        let s: &'static str = "123";
        let n: i32 = (*s).parse().unwrap();
        assert_eq!(n, 123);}

    // Q41: parse failure returns Err
    #[test]
    fn q41_parse_err() {
        let s = "not a number";
        let result = (*s).parse::<i32>();
        assert_eq!(result.is_err(), true);}

    // Q42: chars to String
    #[test]
    fn q42_chars_to_string() {
        let chars: Vec<char> = vec!['r', 'u', 's', 't'];
        let s: String = chars.iter().collect();
        assert_eq!(s, "rust");}

    // Q43: String to Vec<char>
    #[test]
    fn q43_string_to_chars() {
        let s: String = String::from("abc");
        let v: Vec<char> = s.chars().collect();
        assert_eq!(v, vec!['a', 'b', 'c']);}

    // Q44: bytes to String
    #[test]
    fn q44_bytes_to_string() {
        let bytes: Vec<u8> = vec![104, 105];
        let s: String = String::from_utf8(bytes).unwrap();
        assert_eq!(s, "hi");}

    // ===== LEVEL 10: practical patterns =====

    // Q45: reverse a string
    #[test]
    fn q45_reverse() {
        let s: &'static str = "hello";
        let rev: String = s.chars().rev().collect();
        assert_eq!(rev, "olleh");}

    // Q46: check if palindrome
    #[test]
    fn q46_palindrome() {
        fn is_palindrome(s: &str) -> bool {
	    let r: String = s.chars().rev().collect();
	    s == r }
        assert_eq!(is_palindrome("racecar"), true);
        assert_eq!(is_palindrome("hello"), false);}

    // Q47: count occurrences of a char
    #[test]
    fn q47_count_char() {
        let s: &'static str = "mississippi";
	// count 's' occurrences
        let count = s.chars().filter(|c| *c == 's').count();
        assert_eq!(count, 4);}

    // Q48: find index of substring
    #[test]
    fn q48_find() {
        let s: &'static str = "hello world";
        assert_eq!((*s).find("world"), Some(6));
        assert_eq!((*s).find("xyz"), None);}

    // Q49: truncate string to first n chars
    #[test]
    fn q49_first_n_chars() {
        fn first_n(s: &str, n: usize) -> &str {
	    match (*s).char_indices().nth(n) {
		Some((i, _)) => &(*s)[..i],
		None => s,}}
        assert_eq!(first_n("hello world", 5), "hello");
        assert_eq!(first_n("hi", 10), "hi");}

    // Q50: compare strings
    #[test]
    fn q50_compare() {
        let a: String = String::from("hello");
        let b: &'static str = "hello";
        let c: String = String::from("world");
        assert_eq!(a == b, true);
        assert_eq!(a == c, false);
        assert_eq!("a" < "b", true);}
}
