import { expect, test } from "vitest";

test("undefined basics", () => {
  // value but stands for type as well
  let u: undefined = undefined;
  expect(u).toBe(undefined);
});
