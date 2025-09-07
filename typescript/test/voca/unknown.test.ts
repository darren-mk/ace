import { expect, test } from "vitest";

// https://www.w3schools.com/typescript/typescript_special_types.php
// unknown must be type-checked before use
// You can't access properties on an unknown type without type assertion
// You can't call or construct values of type unknown
// can't be used without type check wrap
// expect(ukn1 + 10).toBe(10);

test("unknown basics", () => {
  let ukn1: unknown = 0;
  if (typeof ukn1 == "number") {
    expect(ukn1 + 10).toBe(10);
  }
  let ukn2: unknown = { a: 1, b: 2 };
  if (typeof ukn2 == "object" && ukn2 !== null && "a" in ukn2) {
    expect(ukn2.a).toBe(1);
  }
});
