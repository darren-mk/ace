(comment
  "Takes a set of functions and returns a fn that is the juxtaposition
of those fns.  The returned fn takes a variable number of args, and
returns a vector containing the result of applying each fn to the
args (left-to-right)."
  ((juxt a b c) x) => [(a x) (b x) (c x)])

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
