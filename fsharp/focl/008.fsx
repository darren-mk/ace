// https://4clojure.oxal.org/#/problem/8

let v: Set<string> = 
  Set.ofList ["a"; "a"; "b"; "c"; "c"; "c"; "c"; "d"; "d"]
v.Equals <| set ["a"; "b"; "c"; "d"]