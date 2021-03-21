((complement <) 3 2)
;; => true

(filter (complement odd?) [1 2 3 4])
;; => (2 4)

((complement even?) 1)
;; => true

(#(not (even? %)) 1)
;; => true
