import { expect, test } from "vitest";

test("basics", () => {
  function reverse<T>(items: T[]): T[] {
    let acc: T[] = [];
    for (let i = items.length - 1; i >= 0; i--) {
      acc.push(items[i]);
    }
    return acc;
  }
  expect(reverse([1, 2, 3])).toStrictEqual([3, 2, 1]);
});
