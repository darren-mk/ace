import { expect, test } from "vitest";

test("basics", () => {
  const arr = [1, 2, 3].map((x) => x + 1);
  expect(arr).toStrictEqual([2, 3, 4]);
});
