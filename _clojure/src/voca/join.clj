(clojure.string/join ["w" "o" "r" "d"])
;; => "word"

(apply str ["w" "o" "r" "d"])
;; => "word"

(clojure.string/join [\a \b \c])
;; => "abc"

(clojure.string/join #"  " [\a \b \c])
;; => "a  b  c"
