;; create a function that makes
;; a consumer thread that is not continuing. 

(require '[clojure.core.async :refer
           [go go-loop timeout
            chan thread alts!!
            <! >! <!! >!!]])

(defn make-thread [c]
  (thread
    (let [v (<!! c)]
      (println v))))

(let [c1 (chan)]
  (make-thread c1)
  (>!! c1 "a"))
