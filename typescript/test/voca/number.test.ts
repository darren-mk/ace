import { expect, test } from "vitest";

test("safe integer", () => {
  // Safe in this context refers to the fact that
  // the value cannot be the result of a rounding error.
  expect(Number.MAX_SAFE_INTEGER).toBe(9007199254740991);
  expect(Number.MIN_SAFE_INTEGER).toBe(-9007199254740991);
  expect(Number.isSafeInteger(1)).toBeTruthy;
  expect(Number.isSafeInteger(1.1)).toBeTruthy;
  expect(Number.isSafeInteger(Number.MAX_SAFE_INTEGER)).toBeTruthy;
});

test("nan", () => {
  expect(Math.sqrt(-1)).toBe(NaN);
  expect(Number.isNaN(Math.sqrt(-1))).toBeTruthy;
});

test("infinity", () => {
  expect(Infinity).toBe(Infinity);
  expect(Number.POSITIVE_INFINITY).toBe(Infinity);
  expect(Number.NEGATIVE_INFINITY).toBe(-Infinity);
  expect(Number.POSITIVE_INFINITY > 1).toBeTruthy;
  expect(Number.NEGATIVE_INFINITY < 1).toBeTruthy;
});

test("infinitesimal", () => {
  // the smallest non-zero value representable
  expect(Number.MIN_VALUE).toBe(5e-324);
  expect(Number.MIN_VALUE / 2).toBe(0);
});
