;;;; single value

(def age (atom 10))
;; => #'focl.core/age

age
;; => #<Atom@4847bf9b: 10>

(deref age)
;; => 10

@age
;; => 10

(swap! age inc)
;; => 11

@age
;; => 11

(deref age)
;; => 11


;;;; map 

(def me (atom {:name "darren"
               :age 60}))
;; => #'focl.core/me

(deref me)
;; => {:name "darren", :age 60}

(swap! me update-in [:age] inc)
;; => {:name "darren", :age 61}

@me
;; => {:name "darren", :age 60}

(reset! me :who)
;; => :who

@me
;; => :who



(defn print-unique [ input ]
  (reduce 
   (fn [last-elem x] 
     (when (not= last-elem x)           
       (prn x)
       x
       ))
   nil 
   input))

(print-unique ["aaa" "aaa" "bbb"])
