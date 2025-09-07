import { expect, test } from "vitest";

test("tuple basics", () => {
  let tpl: [number, string, boolean];
  tpl = [1, "yo", true];
  expect(tpl[0]).toBe(1);
});
