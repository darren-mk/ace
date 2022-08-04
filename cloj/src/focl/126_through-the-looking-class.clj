;; https://4clojure.oxal.org/#/problem/126

;; https://www.4clojure.com/problem/126

;; 1
(let [x Class]
  (and (= (class x) x)
       x))
;; second part of and args prevents from using nil.
Class
;; => java.lang.Class
(= (class java.lang.Long) java.lang.Class) ;; => true
(class java.lang.Long) ;; => java.lang.Class
(class 3) ;; => java.lang.Long
3 ;; => 3
