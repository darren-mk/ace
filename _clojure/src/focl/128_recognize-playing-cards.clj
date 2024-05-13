;; https://4clojure.oxal.org/#/problem/128

(require '[clojure.string :as cstr])

;; 1
(range 2 11) :=> '(2 3 4 5 6 7 8 9 10)
(range 0 9) :=> '(0 1 2 3 4 5 6 7 8)
(interleave (range 2 11) (range 0 9))
:=> '(2 0 3 1 4 2 5 3 6 4 7 5 8 6 9 7 10 8)
(apply sorted-map '(2 0 3 1 4 2 5 3 6 4 7 5 8 6 9 7 10 8))
:=> {2 0, 3 1, 4 2, 5 3, 6 4, 7 5, 8 6, 9 7, 10 8}
{"J" 9 "Q" 10 "K" 11 "A" 12}
:=> {"J" 9, "Q" 10, "K" 11, "A" 12}
(cstr/split "DQ" #"") :=> ["D" "Q"]
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
               (cstr/split v #"")
               (first v)
               (get suits v))
        rank (as-> s v
               (cstr/split v #"")
               (second v)
               (get ranks v))]
    {:suit suit
     :rank rank}))
(= {:suit :diamond :rank 10} (f1 "DQ")) :=> true
(= {:suit :heart :rank 3} (f1 "H5")) :=> true
(= {:suit :club :rank 12} (f1 "CA")) :=> true
(= (range 13) (map (comp :rank f1 str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA])) :=> true

;; 2
(defn f2 [s]
  (let [[shape score] (cstr/split s #"")
        suits {:c :club
               :d :diamond
               :h :heart
               :s :spade}
        suit (get suits (-> shape cstr/lower-case keyword))
        special-scores {:t 8 :j 9 :q 10 :k 11 :a 12}
       #_ (range 9)
        ]
    
    suit

    )

  )




(= {:suit :diamond :rank 10} (f2 "DQ"))
(= {:suit :heart :rank 3} (f2 "H5"))
(= {:suit :club :rank 12} (f2 "CA"))
(= (range 13) (map (comp :rank f2 str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA]))
