;; create a function that makes
;; a thread running continuously but slowly.

(require '[clojure.core.async :refer
           [go go-loop timeout
            chan thread alts!!
            close! <! >! <!! >!!]])

(defn make-thread-continuing-slowly [c]
  (thread
    (loop []
      (let [v (<!! c)]
        (when (not (nil? v))
          (prn v)
          (<!! (timeout 3000))
          (recur))))))

(let [c (chan)]
  (do (make-thread-continuing-slowly c)
      (>!! c "a")
      (>!! c "b")
      (>!! c "c")
      (close! c)))
