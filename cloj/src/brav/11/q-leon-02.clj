;; create a function that makes
;; a thread running continuously.

(require '[clojure.core.async :refer
           [go go-loop timeout
            chan thread alts!!
            close! <! >! <!! >!!]])

(defn make-thread-continuing [c]
  (thread
    (loop []
      (let [v (<!! c)]
        (when (not (nil? v))
          (println v)
          (recur))))))

(let [c (chan)]
  (do (make-thread-continuing c)
      (>!! c "a")
      (>!! c "b")
      (>!! c "c")
      (close! c)))
