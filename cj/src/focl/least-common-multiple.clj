;; https://www.4clojure.com/problem/100

;; 1
(sort [5 3 7]) ;; => (3 5 7)
(first [3 5 7]) ;; => 3
(take 5 (iterate #(+ % 3) 3)) ;; => (3 6 9 12 15)
(defn divisible-by-all [x all]
  (apply = true 
   (map #(if (= 0 (mod x %)) true false) all)))
(defn f1 [& nums]
  (let [max-cm (apply * nums)
        small (-> nums sort first)
        applicants (take (/ max-cm small)
                         (iterate #(+ % small) small))]
    (->> applicants
      (filter #(divisible-by-all % nums))
      (sort)
      (first))))
(== (f1 2 3) 6) ;; => true
(== (f1 5 3 7) 105) ;; => true
(== (f1 1/3 2/5) 2) 
(== (f1 3/4 1/6) 3/2)
(== (f1 7 5/7 2 3/5) 210)


;; 2

(range 1 7.5)

(defn divisible-by-all [x all]
  (apply = true 
   (map #(if (zero? (rem x %)) true false) all)))

(def nums [5 3 7])


(divisible-by-all 105 [5 3 7])
(range 1 3)

(defn f2 [& nums]
  (let [minimum (apply max nums)
        maximum (inc (apply * nums))
        applicants (range minimum maximum)
        ]
    (as-> applicants a
         (filter #(divisible-by-all % nums) a)
         (apply min a))))
(max 1/3 2/5) ;; => 2/5
(inc (* 1/3 2/5)) ;; => 17/15
(* (float 2/5) (float 17/15))
(== (f2 2 3) 6)
(== (f2 5 3 7) 105) 
(== (f2 1/3 2/5) 2) 
(== (f2 3/4 1/6) 3/2)
(== (f2 7 5/7 2 3/5) 210)
