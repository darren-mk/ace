import { expect, test } from "vitest";

test("null basics", () => {
  // null is a value and type
  let n: null = null;
  expect(n).toBe(null);
});
