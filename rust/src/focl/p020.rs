/* https://4clojure.oxal.org/#/problem/20
Problem 20
Write a function which returns the second to last element from a sequence.
(= (__ (list 1 2 3 4 5)) 4)
(= (__ ["a" "b" "c"]) "b")
(= (__ [[1 2] [3 4]]) [1 2]) */

#[allow(dead_code)]
fn f020a<T: Clone>(l: &[T]) -> Option<T> {
    if l.len() < 2 { None }
    else { Some(l[l.len() - 2].clone())}}

#[test]
fn t020a() {
    assert_eq!(None, f020a(&[1]));
    assert_eq!(Some(3), f020a(&[1, 2, 3, 4]));}

#[allow(dead_code)]
fn f020b<T> (l: &[T]) -> Option<&T> {
    if l.len() < 2 { None }
    else { Some(&l[l.len() - 2])}}

#[test]
fn t020b() {
    assert_eq!(None, f020b(&[1]));
    assert_eq!(Some(&3), f020b(&[1, 2, 3, 4]));}

#[allow(dead_code)]
fn f020c<T> (l: &[T]) -> Option<&T> {
    l.iter().rev().nth(1)}

#[test]
fn t020c() {
    assert_eq!(Some(&3), f020c(&[1, 2, 3, 4]));
    assert_eq!(None, f020c(&[1]));}
