;; https://www.hackerrank.com/challenges/eval-ex/problem?isFullScreen=true

(require '[clojure.string :as str])

(defn factorial-a [x]
  (case x
    0 1
    1 1
    (*' x (factorial-a (dec x)))))

(factorial-a 200)

(defn factorial-b [x]
  (loop [cnt x
         acc 1]
    (if (zero? cnt)
      acc
      (recur (dec cnt) (*' acc cnt)))))

(factorial-b 200)
