;; https://4clojure.oxal.org/#/problem/54

(defn f1
  ([n l] (f1 n l [[]]))
  ([n l coll]
   (cond (empty? l)
         (remove #(< (count %) n) coll)
         (< (-> coll last count) n)
         (f1 n (rest l) (update coll (-> coll count dec) conj (first l)))
         :else
         (f1 n (rest l) (conj coll [(first l)])))))
(= (f1 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
(= (f1 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
(= (f1 3 (range 8)) '((0 1 2) (3 4 5)))
