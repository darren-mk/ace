import { expect, test } from "vitest";

test("apply", () => {
  function foo(a: number, b: number, c: number) {
    return a + b + c;
  }
  const nums: [number, number, number] = [1, 2, 3];
  expect(foo(...nums)).toBe(6);
});

test("assignment", () => {
  const arr = [1, 2];
  expect([...arr, 3, 4, 5]).toStrictEqual([1, 2, 3, 4, 5]);
  expect([3, ...arr, 4]).toStrictEqual([3, 1, 2, 4]);
});

test("object", () => {
  const point2d = { x: 1, y: 2 };
  const point3d = { ...point2d, z: 3 };
  expect(point3d).toStrictEqual({ x: 1, y: 2, z: 3 });
});
