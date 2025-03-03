;;;; extends?

(defprotocol Area
  (get-area [this]))

(defrecord Rectangle [width height]
  Area
  (get-area [this]
    (println this)
    (* width height)))

(extends? Area Rectangle) ;; => true

;; (extends? Rectangle Area)
;; error

(def rect (->Rectangle 2 3))
rect ;; => {:width 2, :height 3}
(get-area rect) ;; => 6

;;;; extend

(defprotocol IBaz
  (foo [_])
  (bar [_]))
;; => IBaz

(def DefaultBaz
  {:foo (fn [_] "DefaultBaz:foo")
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
