(defn is-small? [number]
  (if (< number 100)
    "yes"
    (do
      (println "Saw a big number" number)
      "no")))
;; => #'user/is-small?

(is-small? 200)
;; Saw a big number 200
;; => "no"
