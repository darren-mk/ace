module Focl.P056

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/56
Problem 56, Find Distinct Items
Difficulty: medium
Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
    (= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
    (= (__ [:a :a :b :b :c :c]) [:a :b :c])
    (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
    (= (__ (range 50)) (range 50))
*)

let l1, r1 = [ 1; 2; 1; 3; 1; 2; 4 ], [ 1; 2; 3; 4 ]

let l2, r2 = [ "a"; "a"; "b"; "b"; "c"; "c" ], [ "a"; "b"; "c" ]

let l3, r3 =
    [ [ 2; 4 ]; [ 1; 2 ]; [ 1; 3 ]; [ 1; 3 ] ], [ [ 2; 4 ]; [ 1; 2 ]; [ 1; 3 ] ]

let f_056_a l = l |> Set.ofList |> Set.toList

[<Fact>]
let t_056_a () =
    f_056_a l1 |> should equal r1
    f_056_a l2 |> should equal r2

let f_056_b l =
    let f acc x =
        if List.contains x acc then acc else acc @ [ x ]

    List.fold f [] l

[<Fact>]
let t_056_b () =
    f_056_b l1 |> should equal r1
    f_056_b l2 |> should equal r2

let f_056_c (l: 'a list) =
    let f (acc: 'a list * Set<'a>) item =
        let result, bible = acc

        if bible.Contains item then
            result, bible
        else
            result @ [ item ], bible.Add item

    List.fold f ([], Set.empty) l |> fst

[<Fact>]
let t_056_c () =
    f_056_c l1 |> should equal r1
    f_056_c l2 |> should equal r2
