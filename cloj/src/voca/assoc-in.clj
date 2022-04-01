(def users
  [{:name "James" :age 26}
   {:name "John" :age 43}])
;; => #'focl.core/users

(assoc-in users [1 :age] 44)
;; => [{:name "James", :age 26} {:name "John", :age 44}]

(assoc-in users [0 :name] "Jackie")
;; => [{:name "Jackie", :age 26} {:name "John", :age 43}]

(assoc-in users [2] {:name "Jack" :age 19})
;; => [{:name "James", :age 26}
;;     {:name "John", :age 43}
;;     {:name "Jack", :age 19}]  

(assoc-in [[1 2] [3 4]] [0 1] 9000)
;; => [[1 9000] [3 4]]


;; implementation

(defn assoc-in-a [col vec v]
  

  )
