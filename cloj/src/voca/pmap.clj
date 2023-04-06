(defn print-and-inc [x]
  (println "processing at" (.getName (Thread/currentThread)))
  (inc x))
;; => #'user/print-and-inc

(map print-and-inc [1 2 3])
;; => processing at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8
;;    processing at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8
;;    processing at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8
;;    (2 3 4)

(pmap print-and-inc [1 2 3])
;; processing at clojure-agent-send-off-pool-37
;; processing at clojure-agent-send-off-pool-51
;; processing at clojure-agent-send-off-pool-52
;; => (2 3 4)
