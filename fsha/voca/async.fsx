// https://learn.microsoft.com/en-us/dotnet/fsharp/language-reference/async-expressions

let work = async {
  do! Async.Sleep 2000
  do printfn "abc"
     printfn "def" }

Async.Start work
