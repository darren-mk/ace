(let [grade 85]
  (cond
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F"))
;; => "B"

(defn cond' [& pvs]
  (if
   (= :else (first pvs)) (last pvs)
   (if (first pvs) (second pvs)
       (apply cond' (-> pvs rest rest)))))
(let [grade 65]
  (cond'
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F"))
;; => "D"

(defn cond'' [& bvs]
  (let [b (first bvs)
        v (second bvs)]
    (if (or b (= :else b)) v
        (apply cond'' (-> bvs rest rest)))))
(cond'' false "A" false "B" :else "C")
;; => "C"
(cond'' false "A" true "B" :else "C")
;; => "B"
