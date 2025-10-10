module Fffp.AsynchronousProgramming

open Xunit
open FsUnit.Xunit

let timer_mutates_value () =
    let timer = new System.Timers.Timer(2000.0)
    // let event = Async.AwaitEvent(timer.Elapsed) |> Async.Start (fun _ -> 123)
    123
