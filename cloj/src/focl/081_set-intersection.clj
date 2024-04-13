;; https://4clojure.oxal.org/#/problem/81

;; reference:
;; https://gist.github.com/SegFaultAX/3607101
(filter even? #{1 2 3 4}) ;; => (4 2)
(contains? #{1 2 3} 2) :=> true
(defn f1 [a b]
  (into #{} (filter #(contains? a %) b)))
(= (f1 #{0 1 2 3} #{2 3 4 5}) #{2 3}) :=> true
(= (f1 #{0 1 2} #{3 4 5}) #{}) :=> true
(= (f1 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}) :=> true

(defn f2 [a b]
  (->> b
       (filter #(contains? a %))
       set))
(= (f2 #{0 1 2 3} #{2 3 4 5}) #{2 3}) :=> true 
(= (f2 #{0 1 2} #{3 4 5}) #{}) :=> true 
(= (f2 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}) :=> true

(defn f3 [a b]
  (into #{}
        (filter (fn [x] (contains? b x))
                a)))
(= (f3 #{0 1 2 3} #{2 3 4 5}) #{2 3}) :=> true 
(= (f3 #{0 1 2} #{3 4 5}) #{}) :=> true 
(= (f3 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}) :=> true

(defn f4 [a b]
  (set (filter #(contains? a %) b)))
(= (f4 #{0 1 2 3} #{2 3 4 5}) #{2 3}) :=> true 
(= (f4 #{0 1 2} #{3 4 5}) #{}) :=> true 
(= (f4 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}) :=> true

