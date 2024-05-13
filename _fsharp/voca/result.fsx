Ok "yay" // Result<string,'a>
Error "nay" // Result<'a,string>

let m = Map.ofList ["foo", 1; "bar", 2 ]
// Map<string,int> = map [("bar", 2); ("foo", 1)]
let search k =
  match m.TryFind k with
  | Some x -> Ok x
  | None -> Error "cannot find!"
search "foo" // Result<int,string> = Ok 1
search "goo" // Result<int,string> = Error "cannot find!"