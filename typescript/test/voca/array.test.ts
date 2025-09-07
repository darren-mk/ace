import { expect, test } from "vitest";

test("array basics", () => {
  let arr: number[] = [11, 22, 33];
  expect(arr[0]).toBe(11);
  expect(arr[1]).toBe(22);
  expect(arr[2]).toBe(33);
});
