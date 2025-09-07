import { expect, test } from "vitest";

test("basics", () => {
  const a = 1;
  // a = 2; // not allowed
  expect(a).toBe(1);
  const obj = { a: 1 };
  obj.a = 2;
  expect(obj.a).toBe(2);
});
