;; https://www.4clojure.com/problem/29

;; 1
(defn f1 [s]
  (clojure.string/join 
   (filter 
    (fn [c] (Character/isUpperCase c))
    s)))
(= (f1 "HeLlO, WoRlD!") "HLOWRD") ;; => true
(empty? (f1 "nothing")) ;; => true
(= (f1 "$#A(*&987Zf") "AZ") ;; => true

;; 2
(def capital-letters
  "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
(defn f2 [s]
  (clojure.string/join 
   (filter
    #(clojure.string/includes? capital-letters (str %))
    s)))
(= (f2 "HeLlO, WoRlD!") "HLOWRD") ;; => true
(empty? (f2 "nothing")) ;; => true
(= (f2 "$#A(*&987Zf2") "AZ") ;; => true
