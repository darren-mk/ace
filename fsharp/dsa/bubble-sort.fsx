let a = [|1; 2; 3; 4; 5; 6|]

let swap x y (array : 'arr []) =
    let temp = array.[x]
    array.[x] <- array.[y]
    array.[y] <- temp

swap 1 2 a

a
