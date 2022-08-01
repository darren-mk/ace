;; https://www.hackerrank.com/challenges/apple-and-orange/problem?isFullScreen=true&h_r=next-challenge&h_v=zen

; Complete the 'countApplesAndOranges' function below.
;
; The function accepts following parameters:
;  1. INTEGER s
;  2. INTEGER t
;  3. INTEGER a
;  4. INTEGER b
;  5. INTEGER_ARRAY apples
;  6. INTEGER_ARRAY oranges

(defn countApplesAndOranges [s t a b apples oranges]
  (let [apple-locations (map #(+ % a) apples)
        orange-locations (map #(+ % b) oranges)
        num-of-apples-in (count (filter #(<= s % t) apple-locations))
        num-of-oranges-in (count (filter #(<= s % t) orange-locations))]
    (print (str num-of-apples-in "\n" num-of-oranges-in))))

(def first-multiple-input
  (clojure.string/split
   (clojure.string/trimr (read-line))
   #" "))

(def s
  (Integer/parseInt
   (nth first-multiple-input 0)))

(def t
  (Integer/parseInt
   (nth first-multiple-input 1)))

(def second-multiple-input
  (clojure.string/split
   (clojure.string/trimr (read-line))
   #" "))

(def a
  (Integer/parseInt
   (nth second-multiple-input 0)))

(def b
  (Integer/parseInt
   (nth second-multiple-input 1)))

(def third-multiple-input
  (clojure.string/split
   (clojure.string/trimr (read-line))
   #" "))

(def m
  (Integer/parseInt
   (nth third-multiple-input 0)))

(def n
  (Integer/parseInt
   (nth third-multiple-input 1)))

(def apples
  (vec (map #(Integer/parseInt %)
            (clojure.string/split
             (clojure.string/trimr (read-line))
             #" "))))

(def oranges
  (vec (map #(Integer/parseInt %)
            (clojure.string/split
             (clojure.string/trimr (read-line))
             #" "))))

(countApplesAndOranges s t a b apples oranges)
