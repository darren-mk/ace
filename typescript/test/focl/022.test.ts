// https://4clojure.oxal.org/#/problem/22
// Problem 22
// Write a function which returns the total number of elements in a sequence.
// (= (__ '(1 2 3 3 1)) 5)
// (= (__ "Hello World") 11)
// (= (__ [[1 2] [3 4] [5 6]]) 3)
// (= (__ '(13)) 1)
// (= (__ '(:a :b :c)) 3)

import { expect, test } from "vitest";

function fA<T>(arr: T[], n?: number): number {
  if (arr.length === 0) {
    return n || 0;
  } else {
    return fA(arr.slice(1), (n || 0) + 1);
  }
}

test("all", () => {
  expect(fA(["jack", "charlie", "miki"])).toBe(3);
});
