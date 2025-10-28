/* https://4clojure.oxal.org/#/problem/22
Problem 22
Write a function which returns the total number of elements in a sequence.
(= (__ '(1 2 3 3 1)) 5)
(= (__ "Hello World") 11)
(= (__ [[1 2] [3 4] [5 6]]) 3)
(= (__ '(13)) 1)
(= (__ '(:a :b :c)) 3) */

#[allow(dead_code)]
fn f022a<T> (l: &[T]) -> usize {
    let mut counter = 0;
    for _ in l { counter += 1; }
    counter }

#[test]
fn t022a() {
    assert_eq!(3, f022a(&[6, 7, 8]))}

#[allow(dead_code)]
fn f022b<T> (l: &[T]) -> usize {
    l.len() }

#[test]
fn t022b() {
    assert_eq!(3, f022b(&[6, 7, 8]))}
