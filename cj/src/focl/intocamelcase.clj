;; https://www.4clojure.com/problem/102

;; 1
(require '[clojure.string :refer [split capitalize]])
(defn f1 [s]
  (let [words (split s #"-")
        head (first words)
        tail (rest words)] 
    (str head
         (join (map capitalize tail)))))
(= (f1 "something") "something") ;; => true
(= (f1 "multi-word-key") "multiWordKey") ;; => true
(= (f1 "leaveMeAlone") "leaveMeAlone") ;; => true
