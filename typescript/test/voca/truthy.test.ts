import { expect, test } from "vitest";

test("truthy basics", () => {
  const myName = "darren";
  expect(typeof !!myName).toBe("boolean");

  let handle = 0;
  if (myName) {
    handle++;
  }
  expect(handle).toBe(1);
  if (!!myName) {
    handle++;
  }
  expect(handle).toBe(2);
});
