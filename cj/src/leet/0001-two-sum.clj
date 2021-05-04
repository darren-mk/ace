;; https://leetcode.com/problems/two-sum/

;; 1

(use '[clojure.spec.alpha :as s])



(defn ranged-rand
  "Returns random int in range start <= rand < end"
  [start end]
  (+ start (long (rand (- end start)))))

We can then provide a specification for that function:

(s/fdef ranged-rand
  :args (s/and (s/cat :start int? :end int?)
               #(< (:start %) (:end %)))
  :ret int?
  :fn (s/and #(>= (:ret %) (-> % :args :start))
             #(< (:ret %) (-> % :args :end))))





(s/fdef ranged-rand
  :args (s/cat :start int? :end int?))
(defn ranged-rand  [start end]
  (+ start end))

(vec #{:a :b})


(defn f1 [vec n]
  (let [filtered (filter #(< % n) vec)
        compls (map #(- n %) filtered)
        matches (clojure.set/intersection
                 (set filtered)
                 (set compls))
        pair (reduce (fn [final matched-item]
                       (if 
                        

                        )
                       

                       )
                     []
                     matches

                     )
        ]
    ;;    vec-candid
;;     compl
pair

    
    )
  

  )

(= (f1 [2 7 11 15] 9)


   [0 1])
(= (f1 [3 2 4] 6)



   [1 2])
(= (f1 [3 3] 6)

   [0 1])
