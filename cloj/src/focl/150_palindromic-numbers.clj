;; https://4clojure.oxal.org/#/problem/150

;; 1
(defn palindromic? [x]
  (let [s (str x)]
    (= (seq (char-array s))
       (reverse s))))
(defn f1 [n]
  (lazy-seq
   (if (palindromic? n)
     (cons n (f1 (inc n)))
     (f1 (inc n)))))
(= (take 26 (f1 0))
   [0 1 2 3 4 5 6 7 8 9
    11 22 33 44 55 66 77 88 99
    101 111 121 131 141 151 161]) ;; => true
(= (take 16 (f1 162))
   [171 181 191 202
    212 222 232 242
    252 262 272 282
    292 303 313 323]) ;; => true
(= (take 6 (f1 1234550000))
   [1234554321 1234664321 1234774321
    1234884321 1234994321 1235005321]) ;; => true
(= (first (f1 (* 111111111 111111111)))
   (* 111111111 111111111)) ;; => true
(= (set (take 199 (f1 0)))
   (set (map #(first (f1 %)) (range 0 10000)))) ;; => true
(= true
   (apply < (take 6666 (f1 9999999)))) ;; => true
(= (nth (f1 0) 10101)
   9102019) ;; => true
