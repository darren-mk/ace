;; clojure.core/juxt
;; ([f] [f g] [f g h] [f g h & fs])
;; Takes a set of functions and returns a fn that is the juxtaposition
;; of those fns.  The returned fn takes a variable number of args, and
;; returns a vector containing the result of applying each fn to the
;; args (left-to-right).
;; ((juxt a b c) x) => [(a x) (b x) (c x)]

((juxt identity name) :a)
;; => [:a "a"]

((juxt :a :b) {:a 1 :b 2 :c 3 :d 4})
;; => [1 2]

(sort-by
 (juxt :a :b)
 [{:a 1 :b 3} {:a 1 :b 2} {:a 2 :b 1}])
;; => ({:a 1, :b 2} {:a 1, :b 3} {:a 2, :b 1})

(def person {:first "darren"
             :middle "minsoo"
             :last "kim"})
;; => #'user/person

((juxt :first :last) person)
;; => ["darren" "kim"]

;; implementation 1
(defn juxt' [& fs]
  (fn [x]
    (-> (for [f fs]
          (f x))
        vec)))
;; => #'user/juxt-alt-1
((juxt' identity name) :a)
;; => [:a "a"]
((juxt' :a :b) {:a 1 :b 2 :c 3 :d 4})
;; => [1 2]

;; https://michaelwhatcott.com/comp-and-juxt/
(def points [[2 4] [1 4] [4 4] [5 1] [1 5] [4 3]])

(map (juxt last first) points)
;; => ([4 2] [4 1] [4 4] [1 5] [5 1] [3 4])

;; compare it with compt
((juxt last first) [1 2 3])
;; => [3 1]

((comp last first) [[1 2 3] 4 5])
;; => 3

;; implementation 2

(defn juxt'' [& fs]
  (fn [& xs] (map (fn [f] (apply f xs)) fs)))

(= [13 72 3 6] ((juxt'' + * min max) 3 4 6))
:=> true
(= ['(1 2 3) '(4 5 6)] ((juxt'' take drop) 3 [1 2 3 4 5 6]))
:=> true
(= ['(0 2 4 6 8) '(1 3 5 7)]
   ((juxt'' (partial filter even?)
          (partial filter odd?)) (range 0 9)))
:=> true
(= ["Gates" "Bill"]
   ((juxt'' :lname :fname) {:fname "Bill" :lname "Gates"}))
:=> true

(defn juxt''' [& fs]
  (fn [& xs] (map #(apply % xs) fs)))
((juxt''' + * min max) 3 4 6) ;; => (13 72 3 6)
((juxt''' take drop) 3 [1 2 3 4 5 6]) ;; => ((1 2 3) (4 5 6))
((juxt''' (partial filter even?)
          (partial filter odd?)) (range 0 9))
;; => ((0 2 4 6 8) (1 3 5 7))
((juxt''' :lname :fname) {:fname "Bill" :lname "Gates"})
;; => ("Gates" "Bill")
