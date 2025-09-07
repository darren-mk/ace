import { expect, test } from "vitest";

function createAdder(n: number) {
  return function (y: number) {
    return y + n;
  };
}

test("closure basics", () => {
  const addOne = createAdder(1);
  const addTwo = createAdder(2);
  expect(addOne(100)).toBe(101);
  expect(addTwo(100)).toBe(102);
});

function createCounter() {
  let val = 0;
  return {
    inc() {
      val++;
    },
    dec() {
      val--;
    },
    getVal() {
      return val;
    },
  };
}

test("multiple fns created", () => {
  let counter = createCounter();
  expect(counter.getVal()).toBe(0);
  counter.inc();
  counter.inc();
  expect(counter.getVal()).toBe(2);
  counter.dec();
  expect(counter.getVal()).toBe(1);
});
