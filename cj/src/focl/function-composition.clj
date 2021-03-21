;; https://www.4clojure.com/problem/58


;; 1
(defn f1 [& fs]
  (reduce
   (fn [fr fx] (fx fr))
   identity
   fs
   )
  )


(= [3 2 1] ((f1 rest reverse) [1 2 3 4])

   )
(= 5 ((f1 (partial + 3) second) [1 2 3 4]))
(= true ((f1 zero? #(mod % 8) +) 3 5 7 9))
(= "HELLO" ((f1 #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
