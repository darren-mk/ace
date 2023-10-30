;; https://4clojure.oxal.org/#/problem/53

(defn inner-f [{:keys [longest candidate] :as _acc} x]
  (let [candidate' (cond (empty? candidate) [x]
                         (= (inc (last candidate)) x) (conj candidate x)
                         :else [x])
        longest' (if (< (count candidate') (count longest))
                   longest
                   candidate')]
    {:longest longest'
     :candidate candidate'}))

(defn f1 [l]
  (let [longest (get (reduce inner-f {} l) :longest)]
    (if (<= (count longest) 1)
      [] longest)))
(= (f1 [1 0 1 2 3 0 4 5]) [0 1 2 3]) ;; => true
(= (f1 [5 6 1 3 2 7]) [5 6]) ;; => true
(= (f1 [2 3 3 4 5]) [3 4 5]) ;; => true
(= (f1 [7 6 5 4]) []) ;; => true
