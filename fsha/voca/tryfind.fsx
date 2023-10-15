let v =
  Map.ofList ["a", 10; "b", 20; "c", 30]

let proc k =
  let a = 
    match v.TryFind k with
    | Some i -> i
    | None -> 0 
  a + 100

proc "b"
// val it: int = 120

proc "z"
// val it: int = 100