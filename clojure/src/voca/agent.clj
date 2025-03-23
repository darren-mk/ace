(def counter
  (agent 0))
;; => #'user/counter

counter
;; => #<Agent@6754918b: 0>

@counter
;; => 0

(send counter
      (fn [x]
        (println "start sleeping")
        (Thread/sleep 3000)
        (println "slept for 3 seconds")
        (inc x)))
;; => #<Agent@60f268aa: 1>

(await counter)
;; => nil

@counter
;; => 1
