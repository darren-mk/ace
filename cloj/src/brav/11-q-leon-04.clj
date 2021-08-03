;; Compose them so that in the last example
;; you have one thread continuously printing results
;; from ch-resp instead of the inline thread.

(require '[clojure.core.async :as a])

(defn printing [c]
  (thread
    (loop []
      (let [v (a/<!! c)]
        (when (some? v)          
          (prn "printed result is: " v)
          (recur))))
    (prn "thread closed.")))

(defn increasing [c]
  (thread
    (loop []
      (let [[v pc :as all] (a/<!! c)]
        (when (some? all)
          (prn "taken value is: " v)
          (a/put! pc (inc v))
          (recur))))
    (prn "thread closed.")))

(def value-channel (chan))
(increasing value-channel)

(def print-channel (chan))
(printing print-channel)

(a/put! value-channel [0 print-channel])
(a/put! value-channel [1 print-channel])

(a/close! value-channel)
(a/close! print-channel)
