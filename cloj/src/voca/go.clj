(ns voca.go
  (:require [clojure.core.async :as a]))

;; https://clojuredocs.org/clojure.core.async/go
;; Asynchronously executes the body, returning immediately to the
;; calling thread. Additionally, any visible calls to <!, >! and alt!/alts!
;; channel operations within the body will block (if necessary) by
;; 'parking' the calling thread rather than tying up an OS thread
;; (or the only JS thread when in ClojureScript). Upon completion of the
;; operation, the body will be resumed.
;; Returns a channel which will receive the result of the body when
;; completed

(a/go (prn "123"))
;; "123"

(doseq [n (range 10)
        :let [i (-> n inc range rand-nth)]]                    
  (a/go
    (a/<! (a/timeout (* i 1000)))
    (println n)))
;; pauses for random time

(do
  (a/go
    (a/<! (a/timeout 1000))
    (println "go #1 done"))
  (a/go
    (println "go #2 done")))
;; go #2 done
;; go #1 done

(let [lc (a/chan)]
  (a/go
    (if (= :ok (a/<! lc))
      (println "go #2 done")
      (println "something wrong with #2")))
  (a/go
    (a/<! (a/timeout 1000))
    (a/>! lc :ok)
    (a/<! (a/timeout 1000))
    (println "go #1 done")))

(def c (a/chan))
(a/go
  (if (= :ok (a/<! c))
    (println "go #2 done")
    (println "something wrong with #2")))
(a/go
  (if (= :ok (a/<! c))
    (println "go #3 done")
    (println "something wrong with #3")))
(a/go
  (a/<! (a/timeout 1000))
  (a/>! c :ok)
  (a/<! (a/timeout 1000))
  (println "go #1 done"))
(a/close! c)
