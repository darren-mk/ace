;; define 5 variables containing random numbers
;; using macro

;; 1
(defmacro def-vars-rand-nums [& var-names]
  (doseq [var-name var-names]
    (list 'def var-name (rand 100))))
;; => #'user/def-vars-rand-nums
(def-vars-rand-nums 'darren 'minsoo 'kim)
;; => nil
;; NOT WORKING - WHY??
