(def things #{"abc" "def"})
;; => #'user/things

(things "abc")
;; => "abc"

(things "zyx")
;; => nil
