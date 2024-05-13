let l = [6; 7; 8; 9]
List.tryItem 0 l // val it: int option = Some 6
List.tryItem 1 l // val it: int option = Some 7
List.tryItem 9 l // val it: int option = None