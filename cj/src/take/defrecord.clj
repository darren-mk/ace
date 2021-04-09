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
