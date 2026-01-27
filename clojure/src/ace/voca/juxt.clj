(ns ace.voca.juxt
  (:require
   [clojure.test :as t]))

;; clojure.core/juxt
;; ([f] [f g] [f g h] [f g h & fs])
;; Takes a set of functions and returns a fn that is the juxtaposition
;; of those fns.  The returned fn takes a variable number of args, and
;; returns a vector containing the result of applying each fn to the
;; args (left-to-right).
;; ((juxt a b c) x) => [(a x) (b x) (c x)]

(t/deftest juxt-basics-test
  (t/is (= [:a "a"] ((juxt identity name) :a)))
  (t/is (= [1 2] ((juxt :a :b) {:a 1 :b 2 :c 3 :d 4})))
  (t/is (= ["darren" "kim"]
           ((juxt :first :last) {:first "darren"
                                 :middle "minsoo"
                                 :last "kim"}))))

(defn juxt-a [& fs]
  (fn [x]
    (-> (for [f fs]
          (f x))
        vec)))

(t/deftest juxt-a-test
  (t/is (= [:a "a"] ((juxt-a identity name) :a)))
  (t/is (= [1 2] ((juxt-a :a :b) {:a 1 :b 2 :c 3 :d 4}))))

(defn juxt-b [& fs]
  (fn [& xs] (map (fn [f] (apply f xs)) fs)))

(t/deftest juxt-b-test
  (t/is (= [13 72 3 6] ((juxt-b + * min max) 3 4 6)))
  (t/is (= ['(1 2 3) '(4 5 6)] ((juxt-b take drop) 3 [1 2 3 4 5 6])))
  (t/is (= ['(0 2 4 6 8) '(1 3 5 7)]
           ((juxt-b (partial filter even?)
                    (partial filter odd?)) (range 0 9))))
  (t/is (= ["Gates" "Bill"]
           ((juxt-b :lname :fname) {:fname "Bill" :lname "Gates"}))))

(defn juxt-c [& fs]
  (fn [& xs] (map #(apply % xs) fs)))

(t/deftest juxt-c-test
  (t/is (= '(13 72 3 6) ((juxt-c + * min max) 3 4 6)))
  (t/is (= '((1 2 3) (4 5 6)) ((juxt-c take drop) 3 [1 2 3 4 5 6])))
  (t/is (= '((0 2 4 6 8) (1 3 5 7))
           ((juxt-c (partial filter even?)
                    (partial filter odd?)) (range 0 9))))
  (t/is (= '("Gates" "Bill")
           ((juxt-c :lname :fname) {:fname "Bill" :lname "Gates"}))))
