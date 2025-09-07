import { expect, test } from "vitest";

enum Direction {
  North,
  West,
  East,
  South,
}

test("enum basics", () => {
  let d: Direction;
  d = Direction.North;
  d = Direction.West;
  expect(d).toBe(Direction.West);
});

enum TaxStatus {
  Single = 0,
  MarriedJointly = 1,
}

test("enum numeric", () => {
  let ts = TaxStatus.MarriedJointly;
  expect(ts).toBe(1);
});
