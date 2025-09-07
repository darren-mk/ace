import { expect, test } from "vitest";

test("any", () => {
  let a: any = 1;
  let b: any = true;
  let c: any = "yo";
  expect(a).toBe(1);
  expect(b).toBe(true);
  expect(c).toBe("yo");
});
