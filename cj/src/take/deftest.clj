(ns deftesting)
(use 'clojure.test)

(defn add-nums [& nums]
  (apply + nums))

(add-nums 1 2)

(deftest add-nums-test
  (is (= 6 (add-nums 1 2 3)))
  (is (= 3 (add-nums 1 2)))
  (is (= 101 (add-nums 1 100))))
;; => #'deftesting/add-nums-test

(run-tests 'deftesting)
;; => {:test 1, :pass 3, :fail 0, :error 0, :type :summary}
