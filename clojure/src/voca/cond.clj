(let [grade 85]
  (cond
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F"))
;; => "B"

(defn cond-a [& pvs]
  (if
   (= :else (first pvs)) (last pvs)
   (if (first pvs) (second pvs)
       (apply cond-a (-> pvs rest rest)))))
(let [grade 65]
  (cond-a
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F"))
;; => "D"
