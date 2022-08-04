;; https://4clojure.oxal.org/#/problem/65

;; 1
(defn f1 [x]
  (case (-> x str first)
    \[ :vector
    \{ :map
    \# :set
    \( :list))
(= :map (f1 {:a 1, :b 2})) ;; => true
(= :list (f1 (range (rand-int 20)))) ;; => true
(= :vector (f1 [1 2 3 4 5 6])) ;; => true
(= :set (f1 #{10 (rand-int 5)})) ;; => true
(= [:map :set :vector :list] (map f1 [{} #{} [] ()])) ;; => true
