// implementation

let rec fold1 f a l =
    match l with
    | [] -> a
    | (x::xs) -> fold1 f (f a x) xs ;;
fold1 (+) 0 [1; 2; 3] = 6 ;; // true
