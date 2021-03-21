(clojure.set/intersection
 #{1 2 3} #{2 3 4}) ;; => #{3 2}

;; intersection
(require '[clojure.set :refer [intersection]]) ;; => nil
(intersection #{1}) ;; => #{1} 
(intersection #{1 2} #{2 3}) ;; => #{2}
(intersection #{1 2} #{2 3} #{3 4}) ;; => #{}
(intersection #{1 :a} #{:a 3} #{:a}) ;; => #{:a}
