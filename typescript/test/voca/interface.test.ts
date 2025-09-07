import { expect, test } from "vitest";

interface Animal {
  hasFeather: boolean;
  age: number;
}

interface Dog extends Animal {
  breed: string;
}

test("interface basics", () => {
  let d: Dog = { hasFeather: true, age: 3, breed: "retriever" };
  expect(d.hasFeather).toBe(true);
});
