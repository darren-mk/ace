;; alter a var permanently

(def address "NJ")
;; => #'user/address

(defn print-address []
  (println address ))

address
;; => "NJ"

(alter-var-root #'address (fn [_] "NV"))
;; => "NV"

address
;; => "NV"


;; #'x = get var of x

;; (var address) equal to #'address

(read-string "#'address")
;;(var address)

(type (var address))
;; clojure.lang.Var

;; figure out difference between var and its content

(meta address)
;; no metadata

(meta #'address)
;; {:line 3,
;;  :column 1,
;;  :file "/home/user/Documents/projects/darren/new-repos/ace/cloj/src/brav/10-q-darren-05.clj",
;;  :name address,
;;  :ns #namespace[user]}

(= #'address address)
;; false

(= @#'address address)
;; true

(read-string "@#'address")
;; (clojure.core/deref (var address))

;; extra fun with-redefs
(let [println1 println]
  (with-redefs [println (fn [x]
                          (println1
                           "Printing x: " x))]
    (print-address)
    ))
