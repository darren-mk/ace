(*
  integer arrays

  zero through 1M
  arg1: int array (always changing)
  arg2: int (e.g. 1001)
  returning: bool

*)

let ex1 =  [| 11; 5; 10; 6; 3; 7; 4; 8 ; 5; 9 |]


let f1 (a: int array) (b: int) : bool =
  let al: int list = List.ofArray a
  let rec f l =
    match l with
    | [] -> false
    | x::xs -> (x = b) || f xs
  f al

f1 [| 11; 5; 10; 6; 3; 7; 4; 8 ; 5; 9 |] 10


let f2 (a: int array) (b: int) : bool =
  let len = Array.length a
  let rec f i =
      if len <= i then false
      elif a[i] = b then true
      else f (i + 1)
  f 0
f2 [| 11; 5; 450; 6; 3; 7; 4; 8 ; 5; 9 |] 10
