;; https://www.4clojure.com/problem/81

;; 1
;; reference:
;; https://gist.github.com/SegFaultAX/3607101
(filter even? #{1 2 3 4}) ;; => (4 2)
(contains? #{1 2 3} 2) ;; => true
(defn f1 [a b]
  (into #{} (filter #(contains? a %) b)))
(= (f1 #{0 1 2 3} #{2 3 4 5}) #{2 3}) ;; => true
(= (f1 #{0 1 2} #{3 4 5}) #{}) ;; => true
(= (f1 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}) ;; => true

;; 2
(defn f2 [a b]
  (->> b
       (filter #(contains? a %))
       set))
(= (f2 #{0 1 2 3} #{2 3 4 5}) #{2 3}) ;; => true 
(= (f2 #{0 1 2} #{3 4 5}) #{}) ;; => true 
(= (f2 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}) ;; => true
