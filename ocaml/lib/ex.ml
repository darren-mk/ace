
let rec last = function
  | [] -> None
  | [ x ] -> Some x
  | _ :: tail -> last tail

let rec last_two_elements_of_a_list = function
  | [] | [_] -> None
  | [ a ; b ] -> Some (a, b)
  | _ :: tail -> last_two_elements_of_a_list tail

let rec nth_element_of_a_list n = function
  | [] -> None
  | head :: tail ->
     if n = 0 then Some head
     else nth_element_of_a_list (n - 1) tail

let rec length_of_a_list = function
  | [] -> 0
  | [_] -> 1
  | _ :: tail -> 1 + length_of_a_list tail

let rec reverse_a_list = function
  | [] -> []
  | [ a ] -> [ a ]
  | head :: tail -> (reverse_a_list tail) @ [ head ]

let palindrome_a l =
  l = List.rev l

let run_length_encoding = function
  | [] -> []
  | [ a ] -> [(1, a)]
  | h :: t -> 



    