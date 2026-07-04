/* https://4clojure.oxal.org/#/problem/5
Problem 5, Lists: conj
conj adds an element to a list. Lists add to the front.
(= __ (conj '(2 3 4) 1))
(= __ (conj '(3 4) 2 1)) */

#[test]
fn t005a() {
    let mut v = vec![2, 3, 4];
    v.insert(0, 1);
    assert_eq!(vec![1,2,3,4], v);}

#[test]
fn t005b() {
    assert_eq!(vec![1,2,3,4], [&[1], &[2,3,4][..]].concat());}



