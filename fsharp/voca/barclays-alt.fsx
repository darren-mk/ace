

(*
So we thought of having a really easy homework,
but has to be submitted in F#
(single file or paragraph, the submission should just a few lines).
Here is the assignment.
Each new term in the Fibonacci sequence is generated by adding the previous two terms.
By starting with 1 and 2, the first 10 terms will be:
1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
By considering the terms in the Fibonacci sequence whose values do not exceed four million,
find the sum of the even-valued terms.
Please submit the code snippet AND the result; result has the form of a single number.
*)


// https://docs.microsoft.com/en-us/dotnet/fsharp/language-reference/functions/recursive-functions-the-rec-keyword
 
 let fib n =
    let rec f acc1 acc2 n =
        match n with
        | 0 -> acc1
        | 1 -> acc2
        | _ -> f acc2 (acc1 + acc2) (n - 1)
    f 0 1 n
    
fib 10