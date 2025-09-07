import { expect, test } from "vitest";

function shout(n: number) {
  return new Promise<string>((f1, f2) => {
    if (n == 7) f1("yay");
    else f2("uh");
  });
}

test("resolve", async () => {
  let result = "";
  await shout(7)
    .then((x) => {
      result = x + "!";
    })
    .catch((x) => {
      result = x + "?";
    });
  expect(result).toBe("yay!");
});

test("reject", async () => {
  let result = "";
  await shout(3)
    .then((x) => {
      result = x + "!";
    })
    .catch((x) => {
      result = x + "?";
    });
  expect(result).toBe("uh?");
});

test("promise all", async () => {
  let results: any[] = [];
  await Promise.all([shout(7), shout(7), shout(7)])
    .then((x) => {
      results.push(x);
    })
    .catch((x) => {
      results.push(x);
    });
  expect(results).toStrictEqual([["yay", "yay", "yay"]]);
});

test("promise race", async () => {
  let results: any[] = [];
  await Promise.race([shout(1), shout(1), shout(1)])
    .then((x) => {
      results.push(x);
    })
    .catch((x) => {
      results.push(x);
    });
  expect(results).toStrictEqual(["uh"]);
});

test("promise any", async () => {
  let results: any[] = [];
  await Promise.any([shout(1), shout(1), shout(7)])
    .then((x) => {
      results.push(x);
    })
    .catch((x) => {
      results.push(x);
    });
  expect(results).toStrictEqual(["yay"]);
});
