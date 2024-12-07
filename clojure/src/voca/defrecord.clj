(defrecord Person [fname lname address])
;; => user.Person

(defrecord Address [street city state zip])
;; => user.Address

(def stu (Person. "Stu" "Halloway"
           (Address. "200 N Mangum"
                      "Durham"
                      "NC"
                      27701)))
;; => #'user/stu

(type stu)
;; => user.Person

(-> stu :address :city)
;; => "Durham"

stu
;; => {:fname "Stu",
;;     :lname "Halloway",
;;     :address
;;     {:street "200 N Mangum", :city "Durham", :state "NC", :zip 27701}}

(assoc stu :fname "James")
;; => {:fname "James",
;;     :lname "Halloway",
;;     :address
;;     {:street "200 N Mangum", :city "Durham", :state "NC", :zip 27701}}

stu
;; => {:fname "Stu",
;;     :lname "Halloway",
;;     :address
;;     {:street "200 N Mangum", :city "Durham", :state "NC", :zip 27701}}

(update-in stu [:address :zip] inc)
;; => {:fname "Stu",
;;     :lname "Halloway",
;;     :address
;;     {:street "200 N Mangum", :city "Durham", :state "NC", :zip 27702}}

stu
;; => {:fname "Stu",
;;     :lname "Halloway",
;;     :address
;;     {:street "200 N Mangum", :city "Durham", :state "NC", :zip 27701}}


;;;; map->

(defrecord Boo [a b])
;; => user.Boo

(def b (Boo. 10 20))
;; => #'user/b

b
;; => {:a 10, :b 20}

(def b2 
  (map->Boo (merge b {:c 30})))
;; => #'user/b2

(type b2)
;; => user.Boo

b2
;; => {:a 10, :b 20, :c 30}

(def c (merge b {:c 30}))
;; => #'user/c

(type c)
;; => user.Boo

c
;; => {:a 10, :b 20, :c 30}
