(require '[clojure.datafy :refer [datafy]])

(datafy 123) ;; => 123
(datafy {:a 1}) ;; => {:a 1}
(datafy (fn [x] (inc x))) ;; => #function[user/eval6175/fn--6176]
(datafy (let [a 123] (+ a 100)));; => 223

(type (ex-info "An Exception" {:msg "something went wrong"}))
;; => clojure.lang.ExceptionInfo

(type (datafy (ex-info "An Exception" {:msg "something went wrong"})))
;; => clojure.lang.PersistentArrayMap
