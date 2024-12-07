;; https://4clojure.oxal.org/#/problem/70

(require '[clojure.string :as cstr])

(defn f1 [s]
  (->> (cstr/split s #" ")
       (sort-by cstr/lower-case)
       (map #(cstr/replace % "." ""))
       (map #(cstr/replace % "!" ""))))
(= (f1 "Have a nice day.")
   ["a" "day" "Have" "nice"])
:=> true
(= (f1 "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])
:=> true
(= (f1 "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])
:=> true
