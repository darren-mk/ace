let starting = Map.ofList ["a", 1]
// val starting: Map<string,int> = map [("a", 1)]

let endup = starting
              .Add("b", 2)
              .Add("c", 3)
// val endup: Map<string,int> = map [("a", 1); ("b", 2); ("c", 3)]
