import { expect, test } from "vitest";

test("find basics", () => {
  const nums = [1, 2, 3, 4, 5];
  expect(nums.find((x) => x == 3)).toBe(3);
  expect(nums.find((x) => x > 3)).toBe(4);
  // returns a single element meeting criterion

  const objs = [
    { a: 1, b: 2 },
    { a: 3, b: 4 },
  ];
  expect(objs.find((obj) => obj.a == 3)).toStrictEqual({ a: 3, b: 4 });
});
