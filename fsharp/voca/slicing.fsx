let l = [101..150]
l[..5] // [101; 102; 103; 104; 105; 106]
l[7..9] // [108; 109; 110]
l[48..] // [149; 150]
l[(-2)..(-4)] // []
l[3..3] // [104]
l[200..200] // []
 
let slice1 (l: 'a list) (a: int) (b: int) =
  let len = List.length l
  let zipped = List.zip [1 .. len] l
  zipped 
  |> List.filter (fun (k: int, v) -> a <= k && k <= b )
  |> List.map (fun (_, v) -> v)
slice1 [100 .. 120] 5 8 // [104; 105; 106; 107]
