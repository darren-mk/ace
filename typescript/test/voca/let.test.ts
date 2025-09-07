import { expect, test } from "vitest";

test("let basics", () => {
  let a = 1;
  if (true) {
    let a = 2;
    expect(a).toBe(2);
  }
  expect(a).toBe(1);
});
