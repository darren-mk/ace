import { expect, test } from "vitest";

test("basics on object", () => {
  let foo = { bar: { x: 1 } };
  let { bar } = foo;
  expect(bar).toStrictEqual({ x: 1 });
  let { x } = bar;
  expect(x).toBe(1);
});

test("deeper on object", () => {
  let foo = { bar: { x: 1 } };
  let {
    bar: { x },
  } = foo;
  expect(x).toBe(1);
});

test("deeper on object", () => {
  let foo = { a: 1, b: 2, c: 3, d: 4 };
  let { a, b, ...rest } = foo;
  expect(a).toBe(1);
  expect(rest).toStrictEqual({ c: 3, d: 4 });
});

test("array", () => {
  let arr = [1, 2, 3, 4, 5];
  let [a, b, ...rest] = arr;
  expect(a).toBe(1);
  expect(b).toBe(2);
  expect(rest).toStrictEqual([3, 4, 5]);
});
