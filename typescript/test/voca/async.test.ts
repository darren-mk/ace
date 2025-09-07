import { expect, test } from "vitest";

function greetSync(name: string): string {
  return `hi, ${name}`;
}

async function greetAsync(name: string): Promise<string> {
  if (name.length > 8) {
    throw new Error("Name too long (max 8 characters).");
  }
  return `hi, ${name}`;
}

test("basics", async () => {
  expect(greetSync("darren")).toBe("hi, darren");
  expect(await greetAsync("darren")).toBe("hi, darren");
  expect(await greetAsync("darren")).rejects.toThrow(/too long/i);
});
