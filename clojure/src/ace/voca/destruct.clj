;; https://clojure.org/guides/destructuring

;; sequential destructuring
(let [[a b] [1 2]] (+ a b)) ;; => 3
(let [[h & _ts] [1 2 3]] h) ;; => 1
(let [[_h & ts] [1 2 3]] ts) ;; => (2 3)
(let [[a _ c] [1 2 3]] [a c]) ;; => [1 3]
(let [[h :as _all] [1 2 3]] h) ;; => 1
(let [[_h :as all] [1 2 3]] all) ;; => [1 2 3]

;; associative destructuring
(let [{title :name} {:name "jack" :age 50}] title) ;; => "jack"
(let [{_a :a, x :x, :or {x "Not found!"}, :as _all}
      {:a "A" :b "B" :c 3 :d 4}] x) ;; => "Not found!"
(let [{_a :a, _x :x, :as all}
      {:a "A" :b "B" :c 3 :d 4}] all) ;; => {:a "A", :b "B", :c 3, :d 4}
(let [{:keys [name _age]}
      {:name "jack" :age 50}] name) ;; => "jack"
(let [{:keys [_name age]}
      {:name "jack" :age 50}] age) ;; => 50
(let [{:strs [first-name _last-name]}
      {"first-name" "Joe" "last-name" "Smith"}] first-name) ;; => "Joe"
(let [{:syms [_first-name last-name]}
      {'first-name "Jane" 'last-name "Doe"}] last-name) ;; => "Doe"

;; keyword arguments 
(defn config [val & {:keys [debug verbose]
                     :or {debug false, verbose false}}]
  (str "val is " val ", debug is " debug ", verbose is " verbose))
(config 10)
;; => "val is 10, debug is false, verbose is false"
(config 5 :debug true)
;; => "val is 5, debug is true, verbose is false"
(config 12 :verbose true :debug true)
;; => "val is 12, debug is true, verbose is true"

;; namespaced keywords destructuring
(def human {:person/name "Franklin"
            :person/age 25
            :hobby/hobbies "running"})
(let [{:keys [hobby/hobbies]
       :person/keys [name age]
       :or {age 0}}
      human]
  (str name " is " age " and likes " hobbies))
;; => "Franklin is 25 and likes running"
