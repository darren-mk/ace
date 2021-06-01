(require
 '[clojure.set :refer [union]])

(union #{1 2} #{2 3})
;; => #{1 3 2}
