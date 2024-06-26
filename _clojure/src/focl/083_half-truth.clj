;; https://4clojure.oxal.org/#/problem/83

;; 1
(contains? [1 2 3] 2) :=> true
(if (= true true) :true :false) :=> :true
(defn f1 [& bools]
  (let [ks (into #{} (map (fn [x] (if (= x true) :t :f))
                          bools))]
    (and (contains? ks :t)
         (contains? ks :f))))
(= false (f1 false false)) :=> true
(= true (f1 true false)) :=> true
(= false (f1 true)) :=> true
(= true (f1 false true false)) :=> true
(= false (f1 true true true)) :=> true
(= true (f1 true true true false)) :=> true

;; 2
;; referred to
;; https://gist.github.com/SegFaultAX/3607101
(defn f2 [& bools]
  (apply not= bools))
(= false (f2 false false)) :=> true
(= true (f2 true false)) :=> true
(= false (f2 true)) :=> true
(= true (f2 false true false)) :=> true
(= false (f2 true true true)) :=> true
(= true (f2 true true true false)) :=> true

;; 3
(defn f3 [& coll]
  (and (.contains coll true)
       (.contains coll false)))
(= false (f3 false false)) :=> true
(= true (f3 true false)) :=> true
(= false (f3 true)) :=> true
(= true (f3 false true false)) :=> true
(= false (f3 true true true)) :=> true
(= true (f3 true true true false)) :=> true

;; 4
(defn f4 [& coll]
  (and
   (contains? (set coll) true)
   (contains? (set coll) false)))
(= false (f4 false false)) :=> true
(= true (f4 true false)) :=> true
(= false (f4 true)) :=> true
(= true (f4 false true false)) :=> true
(= false (f4 true true true)) :=> true
(= true (f4 true true true false)) :=> true

;; 5
(defn f5 [& vs]
  (and 
   (contains? (set vs) true)
   (contains? (set vs) false)))
(= false (f5 false false)) :=> true
(= true (f5 true false)) :=> true
(= false (f5 true)) :=> true
(= true (f5 false true false)) :=> true
(= false (f5 true true true)) :=> true
(= true (f5 true true true false)) :=> true

(defn f6 [& bs]
  (let [sets (set bs)]
    (and (contains? sets true)
         (contains? sets false))))
(= false (f6 false false)) :=> true
(= true (f6 true false)) :=> true
(= false (f6 true)) :=> true
(= true (f6 false true false)) :=> true
(= false (f6 true true true)) :=> true
(= true (f6 true true true false)) :=> true
