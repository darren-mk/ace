
// implementation

let take1 (n: int) (sq: seq<'a>) =
  let rec f (n: int) (l: 'a list) =
    if n = 0 then []
    else [List.head l] @ f (n - 1) (List.tail l)
  f n (List.ofSeq sq) |> Seq.ofList
take1 3 (seq { 1 .. 100 })
// val it: seq<int> = [1; 2; 3]