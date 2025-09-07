import { expect, test } from "vitest";

type Car = { maker: string; model: string; year: number; mileage?: number };

test("object basics", () => {
  let c: Car = { maker: "vw", model: "jetta", year: 2013 };
  expect(c.maker).toBe("vw");
  expect(c.mileage).toBe(undefined);
  c.mileage = 100;
  expect(c.mileage).toBe(100);
});

type PhoneBook = { [fullname: string]: string };

test("object as hashmap", () => {
  let pb: PhoneBook = { JackMo: "321", VinoCha: "654" };
  expect(pb["VinoCha"]).toBe("654");
});

function toInt(s: string): { valid: boolean; value?: number } {
  const x = parseInt(s);
  if (isNaN(x)) {
    return { valid: false };
  } else {
    return { valid: true, value: x };
  }
}

test("optional field", () => {
  expect(toInt("a22")).toStrictEqual({ valid: false });
  expect(toInt("123")).toStrictEqual({ valid: true, value: 123 });
});
