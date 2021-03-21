(interpose ", " ["me" "you" "us"])
;; => ("me" ", " "you" ", " "us") 
(interpose 0 [1 2 3])
;; => (1 0 2 0 3)
