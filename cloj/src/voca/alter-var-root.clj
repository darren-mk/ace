(def s "abc")
;; => #'user/s

s
;; => "abc"

(alter-var-root
 #'s
 (constantly "def"))
;; => "def"

s
;; => "def"
