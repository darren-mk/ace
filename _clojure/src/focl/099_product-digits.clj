;; https://www.4clojure.com/problem/99

;; string split 
(require '[clojure.string :as cstr]) ;; => nil 
(type #"") ;; => java.util.regex.Pattern
(cstr/split "Lisp good!" #"") ;; => ["L" "i" "s" "p" " " "g" "o" "o" "d" "!"]
(cstr/split "Lisp good!" #" ") ;; => ["Lisp" "good!"]
(cstr/split "Lisp good!" #"p") ;; => ["Lis" " good!"]

;; 1
(* 99 9) ;; => 891
(str 891) ;; => "891"
(clojure.string/split "891" #"") ;; => ["8" "9" "1"]
(Integer/parseInt "8") ;; => 8
(map #(Integer/parseInt %) ["8" "9" "1"]) ;; => (8 9 1)
(defn f1 [a b]
  (map #(Integer/parseInt %)
       (clojure.string/split
        (str (* a b)) #"")))
(= (f1 1 1) [1]) ;; => true
(= (f1 99 9) [8 9 1]) ;; => true
(= (f1 999 99) [9 8 9 0 1]) ;; => true

;; 2
(defn f2 [a b]
  (as-> (* a b) v
    (str v)
    (clojure.string/split v #"")
    (map #(Integer/parseInt %) v)))
(= (f2 1 1) [1]) ;; => true
(= (f2 99 9) [8 9 1]) ;; => true
(= (f2 999 99) [9 8 9 0 1]) ;; => true
