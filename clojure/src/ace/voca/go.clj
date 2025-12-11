(require
 '[clojure.core.async :as a]
 '[clojure.string :as cstr])

;; https://clojuredocs.org/clojure.core.async/go
;; Asynchronously executes the body, returning immediately to the
;; calling thread. Additionally, any visible calls to <!, >! and alt!/alts!
;; channel operations within the body will block (if necessary) by
;; 'parking' the calling thread rather than tying up an OS thread
;; (or the only JS thread when in ClojureScript). Upon completion of the
;; operation, the body will be resumed.
;; Returns a channel which will receive the result of the body when
;; completed

(a/go
  (prn "123")
  "abc")
;; "123" is printed
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel 0xc4b576a "clojure.core.async.impl.channels.ManyToManyChannel@c4b576a"]

(doseq [n (range 10)]
  (let [i (-> n inc range rand-nth)]
    (a/go
      (a/<! (a/timeout (* i 1000)))
      (println n))))
;; pauses for random time

(do
  (a/go
    (a/<! (a/timeout 1000))
    (println "go #1 done"))
  (a/go
    (println "go #2 done")))
;; go #2 done
;; go #1 done

(let [c (a/chan)]
  (a/go
    (when (= :ok (a/<! c))
     (println "go block 1 received :ok")))
  (a/go
    (a/<! (a/timeout 1000))
    (println "go block 2 sends :ok")
    (a/>! c :ok)
    (a/<! (a/timeout 1000))))

(def thrds (atom #{}))
(doseq [n (range 500)]
  (a/go
    (swap! thrds conj (.getName (Thread/currentThread)))
    (println n)))
@thrds
#{"async-dispatch-4"
  "async-dispatch-7"
  "async-dispatch-1"
  "async-dispatch-6"
  "async-dispatch-3"
  "async-dispatch-8"
  "async-dispatch-2"
  "async-dispatch-5"}

(def walkie-talkie
  (a/chan))

(def one-time-listner
  (a/go
   (let [msg (a/<! walkie-talkie)]
     (println "received: " msg))))

(a/go
  (loop []
    (when-let [msg (a/<! walkie-talkie)]
      (if (= msg :stop)
        (println "Stopping listener.")
        (do
          (println "Received:" msg)
          (recur))))))

(defn talk
  ([]
   (a/go
     (a/>! walkie-talkie)))
  ([msg]
   (a/go
     (a/>! walkie-talkie msg))))

(talk "yay")
(talk :stop)
