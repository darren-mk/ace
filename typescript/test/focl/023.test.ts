// https://4clojure.oxal.org/#/problem/23
// Problem 23
// Write a function which reverses a sequence.
// (= (__ [1 2 3 4 5]) [5 4 3 2 1])
// (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
// (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
// Special Restrictions : reverse

import { expect, test } from "vitest";

function f_a<T>(arr: T[], result?: T[]): T[] {
  const [head, ...tail] = arr;
  if (!head) {
    return result || [];
  } else {
    return f_a(tail, (result || []).push(head)) || [];
  }
}

test("all", () => {
  expect(f_a([1, 2, 3, 4, 5])).toStrictEqual([5, 4, 3, 2, 1]);
});
