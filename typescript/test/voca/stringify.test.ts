import { expect, test } from "vitest";

test("undefined is omitted", () => {
  const obj = { a: 1, b: null, c: undefined };
  expect(JSON.stringify(obj)).toStrictEqual('{"a":1,"b":null}');
});
