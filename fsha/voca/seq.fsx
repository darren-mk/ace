// https://learn.microsoft.com/en-us/dotnet/fsharp/language-reference/sequences

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
