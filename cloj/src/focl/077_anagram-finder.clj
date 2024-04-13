;; https://4clojure.oxal.org/#/problem/77

(defn f1 [coll]
  (->> coll (group-by set)
       (remove (fn [[_ v]] (< (count v) 2)))
       vals (map set) set))
(= (f1 ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})
:=> true
(= (f1 ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})
:=> true
