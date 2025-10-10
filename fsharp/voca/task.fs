module Voca.Task

open System.Threading.Tasks
open Xunit
open FsUnit.Xunit

[<Fact>]
let ``basic task that creates values in it`` () =
    task {
        let! x = Task.FromResult(1)
        let! y = Task.FromResult(2)
        x + y |> should equal 3
    }
    :> Task


[<Fact>]
let ``basic task that returns value`` () =
    let addLater x y =
        task {
            do! Task.Delay(10)
            return x + y
        }

    let result_task = addLater 1 2
    result_task.Result |> should equal 3
