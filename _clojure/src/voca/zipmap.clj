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
