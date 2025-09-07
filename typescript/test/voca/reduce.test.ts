import { expect, test } from "vitest";

test("basics", () => {
  const result = [1, 2, 3, 4, 5].reduce((acc, x) => acc + x);
  expect(result).toBe(15);
});
