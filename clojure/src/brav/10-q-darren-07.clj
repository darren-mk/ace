;; explore parallel computation
;; on multiple threads using pmap

(defn wait-a-sec-and-inc [x]
  (Thread/sleep 1000)
  (inc x))
;; => #'user/wait-a-sec-and-inc

(map wait-a-sec-and-inc [1 2 3 4 5])
;; => (2 3 4 5 6)
;; takes exactly 5 seconds

(pmap wait-a-sec-and-inc [1 2 3 4 5])
;; => (2 3 4 5 6)
;; takes exactly 1 second
;; because it uses multiple threads
;; starting at the same timing.
