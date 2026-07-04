#[cfg(test)]
mod test_casting {

    // ===== LEVEL 1: basic `as` casting between integers =====

    // Q1: i32 to i64
    // #[test]
    // fn q01_i32_to_i64() {
    //     let a: i32 = 42;
    //     let b: i64 = todo!(); // cast a to i64
    //     assert_eq!(b, 42i64);}

    // Q2: i64 to i32 (fits)
    // #[test]
    // fn q02_i64_to_i32() {
    //     let a: i64 = 100;
    //     let b: i32 = todo!(); // cast a to i32
    //     assert_eq!(b, 100);}

    // Q3: i32 to u32 (positive value)
    // #[test]
    // fn q03_i32_to_u32() {
    //     let a: i32 = 10;
    //     let b: u32 = todo!();
    //     assert_eq!(b, 10u32);}

    // Q4: u32 to i32 (fits)
    // #[test]
    // fn q04_u32_to_i32() {
    //     let a: u32 = 255;
    //     let b: i32 = todo!();
    //     assert_eq!(b, 255);}

    // Q5: i32 to usize
    // #[test]
    // fn q05_i32_to_usize() {
    //     let a: i32 = 5;
    //     let b: usize = todo!();
    //     assert_eq!(b, 5usize);}

    // Q6: usize to i32
    // #[test]
    // fn q06_usize_to_i32() {
    //     let a: usize = 7;
    //     let b: i32 = todo!();
    //     assert_eq!(b, 7);}

    // Q7: use casting to index a vec
    // #[test]
    // fn q07_cast_for_index() {
    //     let v = vec![10, 20, 30];
    //     let i: i32 = 1;
    //     let val = v[todo!()]; // cast i to use as index
    //     assert_eq!(val, 20);}

    // Q8: add usize and i32
    // #[test]
    // fn q08_add_mixed() {
    //     let a: usize = 10;
    //     let b: i32 = 5;
    //     let c: usize = todo!(); // add them as usize
    //     assert_eq!(c, 15);}

    // ===== LEVEL 2: `as` with floats =====

    // Q9: i32 to f64
    // #[test]
    // fn q09_i32_to_f64() {
    //     let a: i32 = 7;
    //     let b: f64 = todo!();
    //     assert_eq!(b, 7.0);}

    // Q10: f64 to i32 (truncates)
    // #[test]
    // fn q10_f64_to_i32() {
    //     let a: f64 = 3.9;
    //     let b: i32 = todo!(); // what happens to the decimal?
    //     assert_eq!(b, todo!());}

    // Q11: f64 to i32 (negative)
    // #[test]
    // fn q11_f64_neg_to_i32() {
    //     let a: f64 = -2.7;
    //     let b: i32 = todo!();
    //     assert_eq!(b, todo!()); // truncates toward zero
    // }

    // Q12: f32 to f64
    // #[test]
    // fn q12_f32_to_f64() {
    //     let a: f32 = 1.5;
    //     let b: f64 = todo!();
    //     assert_eq!(b, 1.5f64);}

    // Q13: integer division vs float division
    // #[test]
    // fn q13_int_vs_float_div() {
    //     let a: i32 = 7;
    //     let b: i32 = 2;
    //     let int_result = a / b;
    //     let float_result = todo!() / todo!(); // cast both to f64, then divide
    //     assert_eq!(int_result, 3);
    //     assert_eq!(float_result, 3.5);}

    // ===== LEVEL 3: `as` with chars and bools =====

    // Q14: char to u32 (unicode code point)
    // #[test]
    // fn q14_char_to_u32() {
    //     let c: char = 'A';
    //     let n: u32 = todo!();
    //     assert_eq!(n, 65);}

    // Q15: u8 to char
    // #[test]
    // fn q15_u8_to_char() {
    //     let n: u8 = 97;
    //     let c: char = todo!(); // u8 can cast to char
    //     assert_eq!(c, 'a');}

    // Q16: bool to integer
    // #[test]
    // fn q16_bool_to_int() {
    //     let t: bool = true;
    //     let f: bool = false;
    //     assert_eq!(t as i32, todo!());
    //     assert_eq!(f as i32, todo!());}

    // Q17: use bool cast for conditional counting
    // #[test]
    // fn q17_bool_counting() {
    //     let v = vec![1, 2, 3, 4, 5, 6];
    //     let even_count: i32 = v.iter().map(|x| (x % 2 == 0) as i32).sum();
    //     assert_eq!(even_count, todo!());}

    // ===== LEVEL 4: dangerous `as` — overflow and truncation =====

    // Q18: i32 negative to u32 — wraps around
    // #[test]
    // fn q18_negative_to_unsigned() {
    //     let a: i32 = -1;
    //     let b: u32 = a as u32;
    //     assert_eq!(b, todo!()); // hint: u32::MAX
    // }

    // Q19: large i64 to i32 — truncation
    // #[test]
    // fn q19_truncation() {
    //     let a: i64 = 3_000_000_000;
    //     let b: i32 = a as i32;
    //     assert_eq!(b == 3_000_000_000, todo!()); // true or false?
    // }

    // Q20: u8 overflow wraps
    // #[test]
    // fn q20_u8_wrap() {
    //     let a: u16 = 256;
    //     let b: u8 = a as u8; // 256 doesn't fit in u8
    //     assert_eq!(b, todo!());}

    // Q21: another u8 wrap
    // #[test]
    // fn q21_u8_wrap2() {
    //     let a: u16 = 300;
    //     let b: u8 = a as u8; // 300 - 256 = ?
    //     assert_eq!(b, todo!());}

    // ===== LEVEL 5: From / Into — safe conversions =====

    // Q22: i32 to i64 with From (no data loss possible)
    // #[test]
    // fn q22_from_i32_i64() {
    //     let a: i32 = 42;
    //     let b: i64 = todo!(); // use i64::from()
    //     assert_eq!(b, 42i64);}

    // Q23: u8 to u32 with From
    // #[test]
    // fn q23_from_u8_u32() {
    //     let a: u8 = 255;
    //     let b: u32 = todo!(); // use From
    //     assert_eq!(b, 255u32);}

    // Q24: Into (same as From, other direction)
    // #[test]
    // fn q24_into() {
    //     let a: i32 = 10;
    //     let b: i64 = todo!(); // use .into()
    //     assert_eq!(b, 10i64);}

    // Q25: From with f32 to f64
    // #[test]
    // fn q25_from_f32_f64() {
    //     let a: f32 = 2.5;
    //     let b: f64 = todo!(); // use From or into
    //     assert_eq!(b, 2.5f64);}

    // Q26: From does NOT exist for lossy conversions
    // this does NOT compile — uncomment, read error, re-comment
    // #[test]
    // fn q26_from_lossy_fails() {
    //     let a: i64 = 42;
    //     let b: i32 = i32::from(a); // i64 -> i32 could lose data
    // }

    // ===== LEVEL 6: TryFrom / TryInto — fallible conversions =====

    // Q27: TryFrom success
    // #[test]
    // fn q27_try_from_ok() {
    //     let a: i64 = 100;
    //     let b: Result<i32, _> = i32::try_from(a);
    //     assert_eq!(b, todo!()); // Ok or Err?
    // }

    // Q28: TryFrom failure
    // #[test]
    // fn q28_try_from_err() {
    //     let a: i64 = 3_000_000_000;
    //     let b: Result<i32, _> = i32::try_from(a);
    //     assert_eq!(b.is_err(), todo!()); // true or false?
    // }

    // Q29: TryInto success
    // #[test]
    // fn q29_try_into_ok() {
    //     use std::convert::TryInto;
    //     let a: i64 = 50;
    //     let b: i32 = a.try_into().unwrap();
    //     assert_eq!(b, todo!());}

    // Q30: TryInto with unwrap_or
    // #[test]
    // fn q30_try_into_fallback() {
    //     use std::convert::TryInto;
    //     let a: i64 = 9_999_999_999;
    //     let b: i32 = a.try_into().unwrap_or(-1);
    //     assert_eq!(b, todo!()); // too big, so fallback
    // }

    // Q31: u32 try_into i32
    // #[test]
    // fn q31_u32_try_into_i32() {
    //     use std::convert::TryInto;
    //     let small: u32 = 100;
    //     let big: u32 = 3_000_000_000;
    //     let a: Result<i32, _> = small.try_into();
    //     let b: Result<i32, _> = big.try_into();
    //     assert_eq!(a.is_ok(), todo!());
    //     assert_eq!(b.is_ok(), todo!());}

    // ===== LEVEL 7: string <-> number conversions =====

    // Q32: i32 to String
    // #[test]
    // fn q32_int_to_string() {
    //     let n: i32 = 42;
    //     let s: String = todo!(); // convert n to String
    //     assert_eq!(s, "42");}

    // Q33: String to i32 (parse)
    // #[test]
    // fn q33_string_to_int() {
    //     let s = "123";
    //     let n: i32 = todo!(); // parse s into i32
    //     assert_eq!(n, 123);}

    // Q34: parse failure
    // #[test]
    // fn q34_parse_fail() {
    //     let s = "abc";
    //     let result = s.parse::<i32>();
    //     assert_eq!(result.is_err(), todo!());}

    // Q35: parse with unwrap_or
    // #[test]
    // fn q35_parse_fallback() {
    //     let good = "42";
    //     let bad = "xyz";
    //     let a: i32 = good.parse().unwrap_or(0);
    //     let b: i32 = bad.parse().unwrap_or(0);
    //     assert_eq!(a, todo!());
    //     assert_eq!(b, todo!());}

    // Q36: f64 to String
    // #[test]
    // fn q36_float_to_string() {
    //     let n: f64 = 3.14;
    //     let s: String = todo!();
    //     assert_eq!(s, "3.14");}

    // Q37: String to f64
    // #[test]
    // fn q37_string_to_float() {
    //     let s = "2.718";
    //     let n: f64 = todo!();
    //     assert_eq!(n, 2.718);}

    // ===== LEVEL 8: practical casting patterns =====

    // Q38: cast in a loop counter
    // #[test]
    // fn q38_loop_cast() {
    //     let v = vec![10, 20, 30];
    //     let mut sum: i64 = 0;
    //     for x in &v {
    //         sum += todo!(); // x is &i32, sum is i64
    //     }
    //     assert_eq!(sum, 60i64);}

    // Q39: percentage calculation
    // #[test]
    // fn q39_percentage() {
    //     let part: u32 = 3;
    //     let total: u32 = 4;
    //     let pct: f64 = todo!(); // calculate 75.0
    //     assert_eq!(pct, 75.0);}

    // Q40: vec length as i32
    // #[test]
    // fn q40_len_as_i32() {
    //     let v = vec![1, 2, 3, 4, 5];
    //     let len: i32 = todo!(); // v.len() returns usize
    //     assert_eq!(len, 5);}

    // Q41: byte to char and back
    // #[test]
    // fn q41_byte_char_roundtrip() {
    //     let byte: u8 = 72;
    //     let ch: char = todo!();    // byte to char
    //     let back: u8 = todo!();    // char back to byte (hint: as u8)
    //     assert_eq!(ch, 'H');
    //     assert_eq!(back, 72);}

    // Q42: sum of mixed types
    // #[test]
    // fn q42_mixed_sum() {
    //     let a: i32 = 10;
    //     let b: u8 = 20;
    //     let c: i64 = 30;
    //     let total: i64 = todo!(); // add all three as i64
    //     assert_eq!(total, 60);}

    // Q43: compare values of different types
    // #[test]
    // fn q43_compare_diff_types() {
    //     let a: i32 = 100;
    //     let b: i64 = 100;
    //     // can't compare directly — cast one
    //     assert_eq!(todo!() == todo!(), true);}

    // ===== LEVEL 9: From/Into for custom types =====

    // Q44: implement From for a custom struct
    // #[test]
    // fn q44_custom_from() {
    //     struct Celsius(f64);
    //     struct Fahrenheit(f64);
    //     impl From<Celsius> for Fahrenheit {
    //         fn from(c: Celsius) -> Self {
    //             todo!() // formula: F = C * 9/5 + 32
    //         }
    //     }
    //     let boiling = Celsius(100.0);
    //     let f: Fahrenheit = Fahrenheit::from(boiling);
    //     assert_eq!(f.0, 212.0);}

    // Q45: Into comes for free when From is implemented
    // #[test]
    // fn q45_into_free() {
    //     struct Meters(f64);
    //     struct Centimeters(f64);
    //     impl From<Meters> for Centimeters {
    //         fn from(m: Meters) -> Self {
    //             Centimeters(m.0 * 100.0)
    //         }
    //     }
    //     let m = Meters(1.5);
    //     let cm: Centimeters = todo!(); // use .into()
    //     assert_eq!(cm.0, 150.0);}

    // Q46: From<&str> for custom type
    // #[test]
    // fn q46_from_str() {
    //     #[derive(Debug, PartialEq)]
    //     enum Color { Red, Green, Blue, Unknown }
    //     impl From<&str> for Color {
    //         fn from(s: &str) -> Self {
    //             match s {
    //                 "red" => todo!(),
    //                 "green" => todo!(),
    //                 "blue" => todo!(),
    //                 _ => todo!(),
    //             }
    //         }
    //     }
    //     assert_eq!(Color::from("red"), Color::Red);
    //     assert_eq!(Color::from("xyz"), Color::Unknown);}
}
