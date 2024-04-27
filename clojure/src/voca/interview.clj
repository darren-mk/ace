


;; 031-324-5491

(print "interview")

;; write a comparator function 'mycompare' that can be
;; used to sort in order of :high then :medium then :low.  It should support
;; other unspecified keywords as lower priority than :low.

;; these should return true:

;; cond or case

(defn mycompare [a b]
  (let [expected #{:high :medium :low}]
    (cond (and (expected a) (not (expected b))) true
          (and (not (expected a)) (expected b)) false
          (and (not (expected a)) (not (expected b))) true
          :else (case [a b]
                  [:high :high] true
                  [:medium :medium] true
                  [:low :low] true
                  [:high :medium] true
                  [:medium :high] false
                  [:high :low] true
                  [:low :high] false
                  [:medium :low] true
                  [:low :medium] false
                  :otherwise false))))

(sort mycompare [:foo :high])
(sort mycompare [:high :foo])

(sort mycompare [:medium :high])

(sort (fn [x y] (< x y)) [3 2 1])


(= (sort mycompare [:high :high :low :medium])   [:high :high :medium :low])
(= (sort mycompare [:foo :high :low :medium])    [:high :medium :low :foo])
(= (sort mycompare [:low :medium :high :foobar]) [:high :medium :low :foobar])
