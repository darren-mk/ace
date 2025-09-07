import { expect, test } from "vitest";

test("basics", () => {
  const arr = [1, 2, 3, 4, 5].filter((x) => x > 3);
  expect(arr).toStrictEqual([4, 5]);
});
