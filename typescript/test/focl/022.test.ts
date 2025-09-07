// https://4clojure.oxal.org/#/problem/22
// Problem 22
// Write a function which returns the total number of elements in a sequence.
// (= (__ '(1 2 3 3 1)) 5)
// (= (__ "Hello World") 11)
// (= (__ [[1 2] [3 4] [5 6]]) 3)
// (= (__ '(13)) 1)
// (= (__ '(:a :b :c)) 3)

import { expect, test } from "vitest";

function fA<T>(arr: T[]): number {
  function inner(n: number, arr: T[]): number {
    let [first, ...rest] = arr;
    if (first) {
      inner(n + 1, rest);
    }
    return n;
  }
  return inner(0, arr);
}

test("all", () => {
  expect(fA(["jack", "charlie", "miki"])).toBe(3);
});
