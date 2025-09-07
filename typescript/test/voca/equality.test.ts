import { expect, test } from "vitest";

// Always use === and !== except for null checks

test("equality basics", () => {
  expect(1 === 1).toBeTruthy;
  let a = { a: 1 };
  let b = a;
  expect(a === b).toBeTruthy;
  expect(null === null).toBeTruthy;
  expect(null === undefined).toBeTruthy;
  expect(undefined === undefined).toBeTruthy;
});
