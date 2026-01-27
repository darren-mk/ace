(ns ace.voca.fnil
  (:require
   [clojure.test :as t]))

((fnil inc 1000) 1) ;; => 2
((fnil inc 1000) nil) ;; => 1001
((fnil + 1) nil) ;; => 1
((fnil + 1) 1 2 3) ;; => 6

(defn fnil-a [f default]
  (fn [x & xs]
    (if (nil? x)
      (f default)
      (apply f (cons x xs)))))
((fnil-a inc 1000) 1) ;; => 2
((fnil-a inc 1000) nil) ;; => 1001
((fnil-a + 1) 1 2 3 4) ;; => 10

(defn fnil-b [f v]
  (fn [& x]
    (if (nil? (first x))
      (f v)
      (apply f x))))
((fnil-b inc 1000) 1) ;; => 2
((fnil-b inc 1000) nil) ;; => 1001
((fnil-b + 1) nil) ;; => 1
((fnil-b + 1) 1 2 3) ;; => 6

(defn fnil-c [f v]
  (fn [x]
    (if (nil? x)
      (f v)
      (f x))))
((fnil-c inc 1000) 1) ;; => 2
((fnil-c inc 1000) nil) ;; => 1001
((fnil-c + 1) nil) ;; => 1

(defn fnil-d [f v]
  (fn [x & xs]
    (if x
      (apply f (cons x xs))
      (f v))))
((fnil-d inc 1000) 1) ;; => 2
((fnil-d inc 1000) nil) ;; => 1001
((fnil-d + 1) 1 2 3 4) ;; => 10

(defn fnil-e [f v]
  (fn [x] (if x (f x) (f v))))
((fnil-e inc 1000) 1) ;; => 2
((fnil-e inc 1000) nil) ;; => 1001

(defn fnil-f [f v]
  (fn [& xs]
    (if (first xs) (apply f xs) v)))
