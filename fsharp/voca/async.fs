module Voca.Async

open System.Collections.Concurrent
open System.Threading
open Xunit
open FsUnit.Xunit

let async_add x y = async { return x + y }

[<Fact>]
let ``simple async that returns sum`` () =
    let result = Async.RunSynchronously(async_add 1 2)
    result |> should equal 3

[<Fact>]
let ``async job that increments counter`` () =
    let mutable count = 0

    let job = async { count <- count + 1 }

    count |> should equal 0
    Async.RunSynchronously job
    count |> should equal 1

[<Fact>]
let ``parallel async jobs that increments counter`` () =
    let mutable count = 0

    let job = async { count <- count + 1 }

    count |> should equal 0
    [ job; job; job ] |> Async.Parallel |> Async.RunSynchronously |> ignore
    count |> should equal 3

[<Fact>]
let ``spawn and forget async job that increments counter`` () =
    let mutable count = 0

    let job =
        async {
            do! Async.Sleep 100
            count <- count + 1
        }

    count |> should equal 0
    Async.Start job
    count |> should equal 0
    Thread.Sleep 150
    count |> should equal 1

[<Fact>]
let ``async parallel basics`` () =
    let logging = ConcurrentBag<int>()

    let fetch id =
        async {
            do! Async.Sleep(10)
            logging.Add(id)
        }

    let instructions = [ 1..10 ] |> List.map fetch
    logging.Count |> should equal 0

    instructions |> Async.Parallel |> Async.RunSynchronously |> ignore
    // logging -> e.g. seq [5; 3; 7; 8; ...]
    logging.Count |> should equal 10

[<Fact>]
let ``async sequential basics`` () =
    let logging = ConcurrentBag<int>()

    let fetch id =
        async {
            do! Async.Sleep(10)
            logging.Add(id)
        }

    let instructions = [ 1..10 ] |> List.map fetch
    logging.Count |> should equal 0

    instructions |> Async.Sequential |> Async.RunSynchronously |> ignore
    logging.Count |> should equal 10
    logging |> should equalSeq { 10..-1..1 }

[<Fact>]
let ``async choice basics`` () =
    let logs = ConcurrentBag<int>()

    let fetch (id: int) (delay: int) =
        async {
            do! Async.Sleep(delay)
            logs.Add(id)
            return Some id
        }

    let fast_job = fetch 1 10
    let slow_job = fetch 2 300
    let jobs = [ slow_job; fast_job ]
    logs.Count |> should equal 0
    let result = jobs |> Async.Choice |> Async.RunSynchronously
    logs.Count |> should equal 1
    logs |> should equalSeq (seq [ 1 ])
    result |> should equal (Some 1)
