let a = seq { 1 .. 100 }
Seq.choose (fun x -> if x < 5 then Some x else None) a
// val it: seq<int> = seq [1; 2; 3; 4]

let choose1 f sq =
  let accf acc x =
    match f x with
    | Some y -> Seq.append acc (Seq.singleton x) 
    | None -> acc
  Seq.fold accf Seq.empty sq
choose1 (fun x -> if x < 5 then Some x else None) a
// val it: seq<int> = seq [1; 2; 3; 4]