;; Agents are not transactional (unlike ref + dosync).

(def counting
  (agent 0))
;; => #'user/counter

counting
;; => #<Agent@6754918b: 0>

@counting
;; => 0

(send counting
      (fn [x]
        (println "start sleeping")
        (Thread/sleep 3000)
        (println "slept for 3 seconds")
        (inc x)))
;; => #<Agent@60f268aa: 1>

(await counting)
;; => nil

@counting
;; => 1
