;; https://www.hackerrank.com/challenges/arrays-ds/problem

;; 1
;; my own answer
(defn read-line-for-int []
  (Integer/parseInt (clojure.string/trim (read-line))))

(defn read-line-for-int-vector []
  (as-> (read-line) v
    (clojure.string/split v #" ")
    (map #(Integer/parseInt %) v)
    (vec v)))

(defn reverse-list [l]
  (if (empty? l)
    nil
    (cons (last l)
          (reverse-list (butlast l)))))

(reverse-list '(1 2 3 4))

;; 2
;; using the given template
; Complete the 'reverseArray' function below.
; The function is expected to return an INTEGER_ARRAY.
; The function accepts INTEGER_ARRAY a as parameter.
(defn reverseArray [a]
  (vec (into '() a)))
;; because 
(vec (into '() [1 2 3])) ;; => [3 2 1]
;; but, leon, why (into '() vector) changes the order?
;; what happens under the hood?
(def fptr
  (get (System/getenv)
       "OUTPUT_PATH"))
(def arr-count
  (Integer/parseInt
   (clojure.string/trim
    (read-line))))
(def arr
  (vec (map #(Integer/parseInt %)
            (clojure.string/split
             (clojure.string/trimr
              (read-line)) #" "))))
(def res (reverseArray arr))
(spit fptr
      (clojure.string/join " " res)
      :append true)
(spit fptr "\n" :append true)
