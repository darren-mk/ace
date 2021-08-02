;; give me a random number between 0 and 100 after 3 seconds.

;; 1
(let [r (future (Thread/sleep 3000)
                (rand 100))]
  (prn "count starts.")
  (prn @r))

;; 2
(future (Thread/sleep 3000)
        (prn (rand 100)))
