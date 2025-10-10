module Voca.Timer

open System
open System.Threading
open Xunit
open FsUnit.Xunit

[<Fact>]
let ``timer fires five times and then stops`` () =
    use doneEvt = new ManualResetEventSlim(false)

    let mutable count = 0
    use timer = new Timers.Timer(100.0) // faster to keep tests snappy
    timer.AutoReset <- true

    timer.Elapsed.Add(fun _ ->
        let c = Interlocked.Increment(&count)

        if c >= 5 then
            timer.Stop() |> ignore
            doneEvt.Set() |> ignore)

    timer.Start()

    // Wait up to 2 seconds for 5 ticks
    let completed = doneEvt.Wait(TimeSpan.FromSeconds(2.0))

    // Clean up (good practice even with 'use')
    timer.Stop()

    // Assertions
    completed |> should equal true
    count |> should equal 5
