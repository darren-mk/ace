(require '[clojure.core.async :refer
           [chan >!! <!! <! >! put! timeout
            thread put! take! go close!]]
                 
         
         )

(require 
         '[clojure.tools.namespace.repl :refer [refresh]]         
         
         )




(def c1 (chan))
(thread (>!! c1 "abc"))
(thread (prn (<!! c1)))

(def c2 (chan))
(go (>! c2 "bcd"))
(go (prn (<! c1)))

(def c3 (chan))
(go (prn (<! c3)))
(go (>! c3 "bcd"))

(def c4 (chan))
(prn (<!! c4))
(>!! c4 "def")

(def c5 (chan))
(>!! c5 "xyz")
(prn (<!! c5))







;;;;; REPL ---------------------------------------------
;; by thread / go
;;;; another (next) channel ------------- waiting -------


(def c (chan))
(go (prn "put >! is done")
    (>! c 789))
(println (<!! c))
;;;;; REPL ---------------------------------------------
;; by thread / go
;;;; another (next) channel ------------- waiting -------


;; create a channel
(def c (chan))
;; run jetty server for high traffic job
(run-jetty "jobs of response to 1 million request per second")
;; appoint this job (reading BIG TEXT FILE) to an IDLE CPU or RESOURCE
(read-100gb-text-file "abc.txt")





(def c-server (chan))
(go (c-server (run-jetty ...)))

(def c-reading (chan))
(go (c-reading (read-100gb-text-file ...)))

(log ...)







(go (>! c (read-big-text-file-and-return "abc.txt")))

;; some resource -> being used by jetty
;; some other resource








;; c2
(def c2 (chan))
(thread (println (<!! c))) 
(>!! c 567) ;; put it!

;; c3
(def c3 (chan))
(>!! c3 567) ;; put it!
(thread (println (<!! c3))) ;; take it!


;; Ex2: Compose them so that in the last example you have one thread
;; continuously printing results from ch-resp instead of the inline
;; thread.

(defn printing [c]
  (thread
    (loop []
      (let [v (<!! c)]
        (when (some? v)          
          (prn "printed result is: " v)
          (recur))))
    (prn "thread closed.")))

(defn increasing [c]
  (thread
    (loop []
      (let [[v pc :as all] (<!! c)]
        (when (some? all)
          (prn "taken value is: " v)
          (put! pc (inc v))
          (recur))))
    (prn "thread closed.")))

(def value-channel (chan))
(increasing value-channel)

(def print-channel (chan))
(printing print-channel)

(put! value-channel [1 print-channel])

(close! value-channel)
(close! print-channel)
