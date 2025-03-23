(ns core
  (:require [clojure.test :refer [deftest is testing]]))

(def items
  [{:id "BOOK1"
    :name "Clean Code"
    :price 39.99}
   {:id "BOOK2"
    :name "Clojure Programming"
    :price 45.50}])

(defn discount [book-id quantity]
  (if (< 2 quantity)
    (case book-id
      "BOOK1" (dec quantity) 
      "BOOK2" (- quantity (* 0.1 quantity)))
    quantity))

(defn calculate-total
  "Calculate total price with discounts:
   - 10% off when buying 3+ same items
   - buy 2 or more and get 1 free for BOOK1"
  {:example (comment (calculate-total {"BOOK1" 1}))}
  [cart]
  (let [f (fn [acc [book-id quantity]]
            (+ acc
               (->> items
                    (filter #(= book-id (:id %)))
                    first :price
                    (* (discount book-id quantity)))))]
    (format "%.2f" (reduce f 0 cart))))

(deftest calculate-total-test
  (testing "basic calculation"
    (is (= "39.99" (calculate-total {"BOOK1" 1})))
    (is (= "91.00" (calculate-total {"BOOK2" 2}))))
  (testing "bulk discount"
    (is (= "122.85" (calculate-total {"BOOK2" 3}))))
  (testing "buy 2 get 1 free"
    (is (= "79.98" (calculate-total {"BOOK1" 3}))))
  (testing "combined cart"
    (is (= "202.83" (calculate-total {"BOOK1" 3 "BOOK2" 3})))))

(clojure.test/run-tests)
