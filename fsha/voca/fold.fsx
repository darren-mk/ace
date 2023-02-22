// A
let rec foldA f a l =
    match l with
    | [] -> a
    | (x::xs) -> foldA f (f a x) xs ;;
foldA (+) 0 [1; 2; 3] = 6 ;; // true
