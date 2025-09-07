import { expect, test } from "vitest";

test("basics", () => {
  let x = 0;
  function alter(): void {
    x++;
  }
  alter();
  expect(x).toBe(1);
});
