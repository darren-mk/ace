Seq.collect (fun x -> Seq.singleton (x * 100)) (seq{1 .. 5})
// val it: seq<int> = seq [100; 200; 300; 400; ...]

let collect1 f sq =
  Seq.fold (fun acc x -> Seq.append acc (f x)) Seq.empty sq
collect1 (fun x -> Seq.singleton (x * 100)) (seq{1 .. 5})
// val it: seq<int> = seq [100; 200; 300; 400; ...]