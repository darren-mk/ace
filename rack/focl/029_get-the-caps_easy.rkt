;; https://www.4clojure.com/problem/29

;; Problem 29
;; Write a function which takes a string and returns a new string containing only the capital letters.
;; (= (__ "HeLlO, WoRlD!") "HLOWRD")
;; (empty? (__ "nothing"))
;; (= (__ "$#A(*&987Zf") "AZ")

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

;; 3
(defn f3 [s]
  (reduce
   (fn [result c]
     (if (Character/isUpperCase c)
       (str result c)
       result))
   ""
   s)) ;; => #'user/f3
(= (f3 "HeLlO, WoRlD!") "HLOWRD") ;; => true
(empty? (f3 "nothing")) ;; => true
(= (f3 "$#A(*&987Zf") "AZ") ;; => true
