(zipmap [:a :b :c] [1 2 3])
;; => {:a 1, :b 2, :c 3}

(zipmap [:a :b :c] [1 2 3 4])
;; => {:a 1, :b 2, :c 3}

(zipmap [:html :body] (repeat {:m 0 :p 0}))
;; => {:html {:m 0, :p 0}, :body {:m 0, :p 0}}

(zipmap [:a :b :c] (repeat 0))
;; => {:a 0, :b 0, :c 0}

;; implementation

;; a
(defn zipmap-a [a b]
  (let [f (fn i [result a b]
            (if (or (empty? a) (empty? b))
              result
              (i (merge result {(first a) (first b)})
                 (rest a) (rest b))))]
    (f {} a b)))
(zipmap-a [:a :b :c] [1 2 3]) ;; => {:a 1, :b 2, :c 3}
(zipmap-a [:a :b :c] [1 2 3 4]) ;; => {:a 1, :b 2, :c 3}
(zipmap-a [:html :body] (repeat {:m 0 :p 0})) ;; => {:html {:m 0, :p 0}, :body {:m 0, :p 0}}
(zipmap-a [:a :b :c] (repeat 0)) ;; => {:a 0, :b 0, :c 0}

(defn zipmap-2
  ([a b]
   (zipmap-2 {} a b))
  ([acc [x & xs] [y & ys]]
   (if-not (and x y) acc
           (zipmap-2 (assoc acc x y)
                     xs ys))))
(zipmap-2 [:a :b :c] [1 2 3]) ;; => {:a 1, :b 2, :c 3}
(zipmap-2 [:a :b :c] [1 2 3 4]) ;; => {:a 1, :b 2, :c 3}
(zipmap-2 [:html :body] (repeat {:m 0 :p 0})) ;; => {:html {:m 0, :p 0}, :body {:m 0, :p 0}}
(zipmap-2 [:a :b :c] (repeat 0)) ;; => {:a 0, :b 0, :c 0}
