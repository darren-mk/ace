open System
open System.Timers

let timer = new Timer(7000.0)
(*
> timer;;
val it: Timer = System.Timers.Timer {AutoReset = true;
                                     Container = null;
                                     Enabled = false;
                                     Interval = 7000.0;
                                     Site = null;
                                     SynchronizingObject = null;}
*)

timer.Elapsed.Add (fun _ -> printfn "hi" |> ignore)

timer.Start()

timer.AutoReset <- false

timer.Stop()
