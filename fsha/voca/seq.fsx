(*
https://learn.microsoft.com/en-us/dotnet/fsharp/language-reference/sequences
A sequence is a logical series of elements all of one type. 
Sequences are particularly useful when you have a large, 
ordered collection of data but do not necessarily expect 
to use all of the elements. Individual sequence elements 
are computed only as required, so a sequence can provide 
better performance than a list in situations 
in which not all the elements are used. 
*)



seq { 1 .. 5 } 
// val it: seq<int> = seq [1; 2; 3; 4; ...]

seq { 1 .. 10 .. 100 } 
// val it: seq<int> = seq [1; 11; 21; 31; ...]

seq { for i in 1 .. 10 -> i * i }
// val it: seq<int> = seq [1; 4; 9; 16; ...]

seq { for i in 1 .. 10 do yield i * i }
// val it: seq<int> = seq [1; 4; 9; 16; ...]

seq { for i in 1 .. 10 do i * i }
// val it: seq<int> = seq [1; 4; 9; 16; ...]

seq { for a in 1 .. 9 do
        for b in 1 .. 9 do
          a * b }
// val it: seq<int> = seq [1; 2; 3; 4; ...]

seq { for n in [1 .. 10 .. 100] -> n - 1}
// val it: seq<int> = seq [0; 10; 20; 30; ...]