;; passage 1

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

;; passage 2

(def b "abc")
;; => #'user/s

b
;; => "abc"

(alter-var-root
 #'b
 (fn [_] "def")) ; takes 1 arg
;; => "def"

b
;; => "def"
