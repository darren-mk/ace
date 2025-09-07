import { expect, test } from "vitest";

class Point2d {
  x: number;
  y: number;
  constructor(x: number, y: number) {
    this.x = x;
    this.y = y;
  }
  add(p: Point2d) {
    return new Point2d(this.x + p.x, this.y + p.y);
  }
}

test("class basics", () => {
  let p1 = new Point2d(2, 7);
  let p2 = new Point2d(3, 5);
  expect(p1.x).toBe(2);
  expect(p1.y).toBe(7);
  expect(p2.x).toBe(3);
  expect(p2.y).toBe(5);
  let p3 = p1.add(p2);
  expect(p3.x).toBe(5);
  expect(p3.y).toBe(12);
});

class Point3d extends Point2d {
  z: number;
  constructor(x: number, y: number, z: number) {
    super(x, y);
    this.z = z;
  }
  add(p: Point3d): Point3d {
    var p2d = super.add(p);
    return new Point3d(p2d.x, p2d.y, this.z + p.z);
  }
}

test("inheritance", () => {
  let p1 = new Point3d(1, 2, 3);
  let p2 = new Point3d(7, 8, 9);
  expect(p1.y).toBe(2);
  expect(p1.z).toBe(3);
  expect(p2.x).toBe(7);
  let p3 = p1.add(p2);
  expect(p3.z).toBe(12);
});

class Counter {
  static numberOfInstances: number = 0;
  value: number = 0;
  constructor() {
    Counter.numberOfInstances++;
    this.value = 0;
  }
  inc() {
    this.value++;
  }
  dec() {
    this.value--;
  }
}

test("static property", () => {
  expect(Counter.numberOfInstances).toBe(0);
  let c1 = new Counter();
  expect(Counter.numberOfInstances).toBe(1);
  let c2 = new Counter();
  expect(Counter.numberOfInstances).toBe(2);
  c1.inc();
  c1.inc();
  expect(c1.value).toBe(2);
  expect(c2.value).toBe(0);
});
