import { expect, test } from "vitest";

test("for basics", () => {
  let n = 0;
  for (let i = 0; i < 5; i++) {
    n += i;
  }
  expect(n).toBe(10);
});

test("in", () => {
  const fruits = ["apple", "orange", "grape"];
  let acc: number[] = [];
  for (let s in fruits) {
    acc.push(parseInt(s));
  }
  expect(acc).toStrictEqual([0, 1, 2]);
});

test("of", () => {
  const fruits = ["apple", "orange", "grape"];
  let acc: string[] = [];
  for (let s of fruits) {
    acc.push(s);
  }
  expect(acc).toStrictEqual(fruits);
});
