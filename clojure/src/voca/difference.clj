(require
 '[clojure.set :refer [difference]])

(difference #{1 2 3}) ;; => #{1 3 2}
(difference #{1 2} #{2 3}) ;; => #{1}
(difference #{1 2 3} #{1} #{1 4} #{3}) ;; => #{2}

(defn difference'
  ([a] a)
  ([a b]
   (if (empty? b) a
       (reduce #(disj %1 %2) a b)))
  ([a b & bs]
   (reduce difference' a (conj bs b))))
(difference' #{1 2 3}) ;; => #{1 3 2}
(difference' #{1 2} #{}) ;; => #{1 2}
(difference' #{1 2} #{2 3}) ;; => #{1}
(difference' #{1 2 3} #{1} #{1 4} #{3}) ;; => #{2}

(defn difference-b
  ([a] a)
  ([a b]
   (if (empty? b) a
       (reduce #(disj %1 %2) a b)))
  ([a b & r]
   (reduce difference-b a (cons b r))))
(difference-b #{1 2 3}) ;; => #{1 3 2}
(difference-b #{1 2} #{}) ;; => #{1 2}
(difference-b #{1 2} #{2 3}) ;; => #{1}
(difference-b #{1 2 3} #{1} #{1 4} #{3}) ;; => #{2}