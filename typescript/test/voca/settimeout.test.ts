import { expect, test } from "vitest";

test("", () => {
  let x = 0;
  function printMyName() {
    x++;
    console.log("yay");
  }
  setTimeout(printMyName, 0);
  expect(x).toBe(0);
});
