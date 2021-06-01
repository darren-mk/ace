;; https://www.4clojure.com/problem/128

;; trial 1
(range 2 11) ;; => (2 3 4 5 6 7 8 9 10)
(range 0 9) ;; => (0 1 2 3 4 5 6 7 8)
(interleave (range 2 11) (range 0 9))
;; => (2 0 3 1 4 2 5 3 6 4 7 5 8 6 9 7 10 8)
(apply sorted-map '(2 0 3 1 4 2 5 3 6 4 7 5 8 6 9 7 10 8))
;; => {2 0, 3 1, 4 2, 5 3, 6 4, 7 5, 8 6, 9 7, 10 8}
{"J" 9 "Q" 10 "K" 11 "A" 12}
;; => {"J" 9, "Q" 10, "K" 11, "A" 12}
(clojure.string/split "DQ" #"") ;; => ["D" "Q"]
(def suits
  {"D" :diamond
   "H" :heart
   "C" :club})
(def ranks
  (let [nums-key (map str (range 2 10)) 
        nums-val (range 0 8)
        nums (apply hash-map (interleave nums-key nums-val))
        letters (hash-map "T" 8 "J" 9 "Q" 10 "K" 11 "A" 12)]
    (merge nums letters)))
(defn f1 [s]
  (let [suit (as-> s v
               (clojure.string/split v #"")
               (first v)
               (get suits v))
        rank (as-> s v
               (clojure.string/split v #"")
               (second v)
               (get ranks v))]
    {:suit suit
     :rank rank}))
(= {:suit :diamond :rank 10} (f1 "DQ")) ;; => true
(= {:suit :heart :rank 3} (f1 "H5")) ;; => true
(= {:suit :club :rank 12} (f1 "CA")) ;; => true
(= (range 13) (map (comp :rank f1 str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA])) ;; => true

