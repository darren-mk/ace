;; You have two channels, and a single consumer thread.  The
;; consumer thread is supposed to take from the first channel which
;; happens to have a value available.

(require '[clojure.core.async :as a])

(def c (chan))
(def c-a (chan))
(def c-b (chan))

(go
  (put! c [c-a c-b]))
(put! c-b "value")
(take! c (fn [x] x))

;; CANNOT SOLVE ...
