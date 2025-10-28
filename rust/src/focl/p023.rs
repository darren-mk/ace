/* https://4clojure.oxal.org/#/problem/23
Problem 23
Write a function which reverses a sequence.
(= (__ [1 2 3 4 5]) [5 4 3 2 1])
(= (__ (sorted-set 5 7 2 7)) '(7 5 2))
(= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
Special Restrictions : reverse */

#[allow(dead_code)]
fn f023a<T> (l: &[T]) -> usize {
    let mut counter = 0;
    for _ in l { counter += 1; }
    counter }

#[test]
fn t023a() {
    assert_eq!(3, f023a(&[6, 7, 8]))}

#[allow(dead_code)]
fn f023b<T> (l: &[T]) -> usize {
    l.len()}

#[test]
fn t023b() {
    assert_eq!(3, f023b(&[6, 7, 8]))}
