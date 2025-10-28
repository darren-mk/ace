/* https://4clojure.oxal.org/#/problem/21
Problem 21
Write a function which returns the Nth element from a sequence.
(= (__ '(4 5 6 7) 2) 6)
(= (__ [:a :b :c] 0) :a)
(= (__ [1 2 3 4] 1) 2)
(= (__ '([1 2] [3 4] [5 6]) 2) [5 6]) */

#[allow(dead_code)]
fn f021a<T> (l: &[T], n: usize) -> Option<&T> {
    l.get(n)}

#[test]
fn t021a() {
    assert_eq!(Some(&2), f021a(&[1, 2, 3, 4], 1));}
