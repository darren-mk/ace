(def a (map println [1 2 3]))
;; => #'user/a
;; nothing prints

(def b (doall (map println [1 2 3])))
;; => #'user/b
;; 1
;; 2
;; 3
