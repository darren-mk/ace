/* https://4clojure.oxal.org/#/problem/3
Problem 3, Intro to Strings
Clojure strings are Java strings, apply str to parameter.
(= __ (.toUpperCase "hello world")) */

#[test]
fn t003a() {
    assert_eq!("HELLO WORLD", "hello world".to_uppercase());}
