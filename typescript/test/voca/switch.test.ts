import { expect, test } from "vitest";

test("basics", () => {
  let given = 2;
  let x = 1;
  switch (given) {
    case 1: {
      x = x * 10;
      break;
    }
    case 2: {
      x = x * 20;
      break;
    }
    case 3: {
      x = x * 30;
      break;
    }
  }
  expect(x).toBe(20);
});
