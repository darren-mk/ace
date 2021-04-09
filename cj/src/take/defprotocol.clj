(defprotocol Fly
  "A simple protocol for flying"
  (fly [this] "Method to fly"))
;; => Fly

(type Fly)
;; => clojure.lang.PersistentArrayMap

Fly
;; => {:on user.Fly,
;;     :on-interface user.Fly,
;;     :doc "A simple protocol for flying",
;;     :sigs {:fly {:name fly, :arglists ([this]), :doc "Method to fly"}},
;;     :var #'user/Fly,
;;     :method-map {:fly :fly},
;;     :method-builders {#'user/fly #function[user/eval5603/fn--5604]}}

(defrecord Bird [name species]
  Fly
  (fly [this] (str (:name this) " flies...")))
;; => user.Bird

Bird
;; => user.Bird

(type Bird)
;; => java.lang.Class

(defrecord Snake [name species]
  Fly
  (crawl [this] (str (:name this) " flies...")))
;; Caused by java.lang.IllegalArgumentException
;;  Can't define method not in interfaces: crawl

(extends? Fly Bird)
;; => true

(def crow (Bird. "Crow" "Corvus corax"))
;; => #'user/crow

(fly crow)
;; => "Crow flies..."
