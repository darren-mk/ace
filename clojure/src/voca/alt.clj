(require '[clojure.core.async :as a])

(let [c1 (a/chan)
      c2 (a/chan)]
  (a/go (let [[v ch] (a/alts! [c1 c2])]
          (println v)
          (println ch)))
  (case (rand-int 2)
    0 (a/go (a/>! c1 "yo!"))
    1 (a/go (a/>! c2 "ye!"))))
;; ye!
;; 0x1a290b36
;; yo!
;; 0x4eaee42b
