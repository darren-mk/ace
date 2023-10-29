let f (l: int list) = List.tryHead l
f [] // val it: int option = None
f [1; 2; 3] // val it: int option = Some 1
f [7] // val it: int option = Some 7

let tryHead1 (l: int list) : int option =
  try Some (List.head l)
  with | _ -> None
tryHead1 [] // None
tryHead1 [1; 2; 3; 4] // Some 1