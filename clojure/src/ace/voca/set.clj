(def things #{"abc" "def"})
;; => #'user/things

(things "abc")
;; => "abc"

(things "zyx")
;; => nil

(#{1 2 3} 1)
;; => 1

(#{1 2 3} 0)
;; => nil
