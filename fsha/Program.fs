module Program

open System

let f1 (s:string) = s.ToUpper()

f1 "HeLlO, WoRlD!" |> printf "%s"