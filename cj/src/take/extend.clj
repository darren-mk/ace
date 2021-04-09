;;;; extends?

(defprotocol Area
  (get-area [this]))
;; => Area

(defrecord Rectangle [width height]
  Area
  (get-area [this]
    (* width height)))
;; => user.Rectangle

(extends? Area Rectangle)
;; => true

;; (extends? Rectangle Area)
;; error


;;;; extend

(defprotocol IBaz
  (foo [_])
  (bar [_]))
;; => IBaz

(def DefaultBaz
  {:foo (fn [_] (str "DefaultBaz:foo"))
   :bar (fn [_] (str "DefaultBaz::bar"))})
;; => #'user/DefaultBaz

(defrecord MyBaz [])
;; => user.MyBaz

(extend MyBaz
  IBaz
  DefaultBaz)
;; => nil

(def my-baz (->MyBaz))
;; => #'user/my-baz

(foo my-baz)
;; => "DefaultBaz:foo"

(bar my-baz)
;; => "DefaultBaz::bar"
