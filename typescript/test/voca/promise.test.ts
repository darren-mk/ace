import { expect, test } from "vitest";
// import fs = require("fs");

test("basics", () => {
  const myPromise: Promise<string> = new Promise((resolve, reject) => {
    if (1 < 2) {
      const y = 1 / 0;
      console.log(y);
      let e = new Error("@@@@ Operation failed.");
      resolve("@@@@ Success!");
    } else {
      reject(new Error("@@@@ Operation failed."));
    }
  });

  myPromise
    .then((value) => {
      console.log(value); // "Success!"
    })
    .catch((error) => {
      console.error(error.message); // "Operation failed."
    })
    .finally(() => {
      console.log("Promise operation complete.");
    });
});
