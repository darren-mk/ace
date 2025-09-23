// https://4clojure.oxal.org/#/problem/21
// Problem 21
// Write a function which returns the Nth element from a sequence.
// (= (__ '(4 5 6 7) 2) 6)
// (= (__ [:a :b :c] 0) :a)
// (= (__ [1 2 3 4] 1) 2)
// (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])

import { expect, test } from "vitest";

function fA<T>(arr: T[], i: number): T {
  if (i === 0) {
    return arr[0];
  } else {
    return fA(arr.slice(1), i - 1);
  }
}

test("all", () => {
  expect(fA([4, 5, 6, 7], 2)).toBe(6);
});
