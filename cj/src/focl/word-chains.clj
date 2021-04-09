;; https://www.4clojure.com/problem/82

;; 1



d returns true if they can be arranged into one continous word chain, and false if they cannot.
test not run	

(= true (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))

test not run	

(= false (__ #{"cot" "hot" "bat" "fat"}))

test not run	

(= false (__ #{"to" "top" "stop" "tops" "toss"}))

test not run	

(= true (__ #{"spout" "do" "pot" "pout" "spot" "dot"}))

test not run	

(= true (__ #{"share" "hares" "shares" "hare" "are"}))

test not run	

(= false (__ #{"share" "hares" "hare" "are"}))



Code which fills in the blank: 
