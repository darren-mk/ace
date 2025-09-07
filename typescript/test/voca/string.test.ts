import { expect, test } from "vitest";

test("interpolation", () => {
  expect("abc" + "def").toBe("abcdef");
  const s = "there";
  expect(`here, ${s}, and ...`).toBe("here, there, and ...");
});
