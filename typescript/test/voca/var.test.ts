import { expect, test } from "vitest";

test("var basic", () => {
  var a = 1;
  if (true) {
    var a = 2;
  }
  expect(a).toBe(2);
});
