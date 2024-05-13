(remove pos? [1 -2 2 -1 3 7 0]) ;;=> (-2 -1 0)
(remove nil? [1 nil 2 nil 3 nil]) ;;=> (1 2 3)
(remove #(zero? (mod % 3)) (range 1 21)) ;;=> (1 2 4 5 7 8 10 11 13 14 16 17 19 20)
(remove even? (range 10)) ;;=> (1 3 5 7 9)
(remove (fn [x]
  (= (count x) 1))
  ["a" "aa" "b" "n" "f" "lisp" "clojure" "q" ""])
;;=> ("aa" "lisp" "clojure" "")

; When coll is a map, pred is called with key/value pairs.
(remove #(> (second %) 100)
       {:a 1
        :b 2
        :c 101
        :d 102
        :e -1})
;;=> ([:a 1] [:b 2] [:e -1])
link
;; remove items from a set/list

(remove #{:a} #{:b :c :d :a :e})
;;=> (:e :c :b :d)

(remove #{:a} [:b :c :d :a :e :a :f])
;;=> (:b :c :d :e :f)
link
;; use map as a pred

(remove {:a 42 :b 69} #{:a :b :c})
;;=> (:c)
link
;; remove all the hyphens in an ISBN Number

(into [] (remove #{\-}) "3-598-21508-8")
;;=> [\3 \5 \9 \8 \2 \1 \5 \0 \8 \8]

;; remove is used in the capacity of a transducer
link
;; remove unique elements from collection

(def nums (concat (range 10) (range 5 15)))

(keys (remove (fn [[k v]] (= v 1))
              (frequencies nums)))
;;=> (7 6 9 5 8)

;; remove unique elements from collection, preserving order
(defn keep-duplicates [coll]
        (sort-by #((into {} (map-indexed vector coll)) %) 
                 (keys (remove (fn [[k v]] (= v 1))
                               (frequencies coll)))))

(keep-duplicates nums)
;; => (5 6 7 8 9)

(def rev-nums (reverse nums))

(keep-duplicates rev-nums)
;;=> (9 8 7 6 5)
