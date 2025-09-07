import { expect, test } from "vitest";

type NumOrString = Number | String;

function pass(x: NumOrString): NumOrString {
  return x;
}

test("basics", () => {
  expect(pass(1)).toBe(1);
  expect(pass("abc")).toBe("abc");
  // expect(pass(true)).toBe("abc");
});
