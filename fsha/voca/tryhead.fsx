let f (l: int list) = List.tryHead l
f [] // val it: int option = None
f [1; 2; 3] // val it: int option = Some 1
f [7] // val it: int option = Some 7