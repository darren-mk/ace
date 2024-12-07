;; https://www.hackerrank.com/challenges/2d-array/problem?h_r=next-challenge&h_v=zen

;; 1
;; Complete the 'hourglassSum' function below.
;; The function is expected to return an INTEGER.
;; The function accepts 2D_INTEGER_ARRAY arr as parameter.
(defn hourglassSum [arr]
  arr)

(def shape [0 1 2 7 12 13 14])

(def a [[1 1 1 0 0 0]
        [0 1 0 0 0 0]
        [1 1 1 0 0 0]
        [0 0 2 4 4 0]
        [0 0 0 2 0 0]
        [0 0 1 2 4 0]])

(defn pick [indices]
  (map #(nth (flatten a) %) indices))
