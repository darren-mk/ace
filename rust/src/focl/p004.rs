/* https://4clojure.oxal.org/#/problem/4
Problem 4, Intro to Lists
Lists can be constructed with either a function or a quoted form.
(= (list :a :b :c) '(:a :b :c)) */

#[test]
fn t004a() {
    let from_vec: Vec<&str> = vec!["a", "b", "c"];
    let from_slice: Vec<&str> = ["a", "b", "c"].to_vec();
    let from_iter: Vec<&str> = ["a", "b", "c"].iter().copied().collect();
    assert_eq!(from_vec, from_slice);
    assert_eq!(from_vec, from_iter);}
