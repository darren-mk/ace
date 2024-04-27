Seq.distinct <| seq{1;1;2;2;2;3;4;5}
// val it: seq<int> = seq [1; 2; 3; 4; ...]

let distinct1 sq =
  let f (acc: 'c Set) x = acc.Add(x)
  Seq.fold f Set.empty sq |> Set.toSeq 
seq{1;1;2;2;2;3;4;5} |> distinct1
// val it: seq<int> = set [1; 2; 3; 4; 5]