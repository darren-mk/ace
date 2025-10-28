/* https://4clojure.oxal.org/#/problem/24
Problem 24, Sum It All Up
Difficulty: easy
Write a function which returns the sum of a sequence of numbers.
(= (__ [1 2 3]) 6)
(= (__ (list 0 -2 5 5)) 8)
(= (__ #{4 2 1}) 7)
(= (__ '(0 0 -1)) -1)
(= (__ '(1 10 3)) 14) */

#[allow(dead_code)]
fn f024a(l: &[i32]) -> i32 {
    let mut sum = 0;
    for x in l {sum += x}
    sum }

#[test]
fn t024a() {
    assert_eq!(6, f024a(&[1,2,3]))}
