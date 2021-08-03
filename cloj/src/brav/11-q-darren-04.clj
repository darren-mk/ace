;; create a random number and save it somewhere in runtime,
;; print it after 3 seconds,
;; and then remove the value by code.

(require '[clojure.core.async :as a])

;; 1
(def c (a/chan))
(do
  (a/thread (a/>!! c (rand 100)))
  (Thread/sleep 3000)
  (prn (a/<!! c))
  (a/close! c))
;; no need to close channel
;; the number is garbage-collected
;; when it is taken out from the channel.

;; 2
(def c (a/chan))
(do
  (a/go (a/>! c (rand 100)))
  (a/<!! (a/timeout 3000))
  (prn (a/<!! c)))

;; 3
;; meet the requirements without core.async
(let [rn (rand 100)]
  (Thread/sleep 3000) (prn rn))
