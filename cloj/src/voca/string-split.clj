(require '[clojure.string :refer [split]])


(split "Clojure is awesome!" #" ")
;; => ["Clojure" "is" "awesome!"]

(type (split "Clojure is awesome!" #" "))
;; => clojure.lang.PersistentVector

(split "q1w2e3r4t5y6u7i8o9p0" #"\d+")
;; => ["q" "w" "e" "r" "t" "y" "u" "i" "o" "p"]

(split "q1w2e3r4t5y6u7i8o9p0" #"\d+" 3)
;; => ["q" "w" "e3r4t5y6u7i8o9p0"]

(split " something and ACamelName " #"(?=[A-Z])")
;; => [" something and " "A" "Camel" "Name "]





(split "q1w2e3r4t5y6u7i8o9p0" #"\n")
