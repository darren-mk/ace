module concat

open Xunit
open FsUnit.Xunit

[<Fact>]
let ``appending two lists should result in a combined list`` () =
    [1; 2] @ [3; 4] |> should equal [1; 2; 3; 4]
