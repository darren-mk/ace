// A    
let containsA v l = List.fold (fun a x -> v = x || a) false l
containsA 3 [1; 2; 3; 4; 5] = true
containsA 6 [1; 2; 3; 4; 5] = false