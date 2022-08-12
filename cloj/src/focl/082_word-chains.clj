;; https://4clojure.oxal.org/#/problem/82


;; 1
(defn f1 [s]
  nil
  )

(= true (f1 #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))
(= false (f1 #{"cot" "hot" "bat" "fat"}))
(= false (f1 #{"to" "top" "stop" "tops" "toss"}))
(= true (f1 #{"spout" "do" "pot" "pout" "spot" "dot"}))
(= true (f1 #{"share" "hares" "shares" "hare" "are"}))
(= false (f1 #{"share" "hares" "hare" "are"}))
