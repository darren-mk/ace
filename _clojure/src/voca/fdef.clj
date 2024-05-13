(require '[clojure.spec.alpha :as s])

(s/fdef add-two-nums
  :args (s/cat :a int? :b int?)
  :ret int?)
(defn add-two-nums [a b]
  (+ a b))

(add-two-nums 2 3)
;; => 5

(comment
  (require
   '[clojure.spec.test.alpha :as stest])
  (stest/instrument `add-two-nums))
