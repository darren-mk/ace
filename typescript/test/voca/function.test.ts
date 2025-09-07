import { expect, test } from "vitest";

test("arrow function", () => {
  const addOne = (x: number) => x + 1;
  expect(addOne(1)).toBe(2);
});

test("rest params", () => {
  function getFriends(_me: string, _you: string, ...allOthers: string[]) {
    return allOthers;
  }
  expect(getFriends("darren", "kika", "miki", "dako")).toStrictEqual([
    "miki",
    "dako",
  ]);
});
