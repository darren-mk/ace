(group-by count ["a" "as" "aa" "qwer"])
;; => {1 ["a"], 2 ["as" "aa"], 4 ["qwer"]}

(group-by type [1 :a 2 :b "c" "e"])
;; => {java.lang.Long [1 2],
;;     clojure.lang.Keyword [:a :b],
;;     java.lang.String ["c" "e"]}
