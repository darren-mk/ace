;; https://4clojure.oxal.org/#/problem/73

(defn f1 [board]
  (let [f (fn [vc]
            (let [uni (set vc)]
              (when (and (= 1 (count uni))
                         (not= :e (first uni)))
                (first uni))))
        h1 (-> board first f)
        h2 (-> board second f)
        h3 (-> board last f)
        v1 (->> board (map first) f)
        v2 (->> board (map second) f)
        v3 (->> board (map last) f)
        d1 (-> [(-> board first first)
                (-> board second second)
                (-> board last last)] f)
        d2 (-> [(-> board first last)
                (-> board second second)
                (-> board last first)] f)]
    (first (remove nil? [h1 h2 h3 v1 v2 v3 d1 d2]))))
(= nil (f1 [[:e :e :e]
            [:e :e :e]
            [:e :e :e]]))
:=> true
(= :x (f1 [[:x :e :o]
           [:x :e :e]
           [:x :e :o]]))
:=> true
(= :o (f1 [[:e :x :e]
           [:o :o :o]
           [:x :e :x]]))
:=> true
(= nil (f1 [[:x :e :o]
            [:x :x :e]
            [:o :x :o]]))
:=> true
(= :x (f1 [[:x :e :e]
           [:o :x :e]
           [:o :e :x]]))
:=> true
(= :o (f1 [[:x :e :o]
           [:x :o :e]
           [:o :e :x]]))
:=> true
(= nil (f1 [[:x :o :x]
            [:x :o :x]
            [:o :x :o]]))
:=> true
