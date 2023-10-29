// usage //

List.replicate 3 "a"
// val it: string list = ["a"; "a"; "a"]

Array.replicate 3 "a"
// val it: string array = [|"a"; "a"; "a"|]

Seq.replicate 3 "a"
// val it: seq<string> = seq ["a"; "a"; "a"]

// implementation //

let rec replicate1 n v =
  match n with
  | 0 -> []
  | _ -> [v] @ (replicate1 (n - 1) v)
replicate1 3 "a" // ["a"; "a"; "a"]
replicate1 4 2 // [2; 2; 2; 2]

let replicate2 n v =
  List.map (fun _ -> v) [1 .. n]
replicate2 3 "a" // ["a"; "a"; "a"]
replicate2 4 2 // [2; 2; 2; 2]

let replicate3 n v =
  List.fold (fun acc x -> acc @ [v] ) [] [ 1 .. n ]
replicate3 3 "a" // ["a"; "a"; "a"]
replicate3 4 2 // [2; 2; 2; 2]