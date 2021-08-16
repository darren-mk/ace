;; print something to the repl


;; https://www.braveclojure.com/zombie-metaphysics/
;; ... this binding behavior prevents us from
;; easily creating a fun demonstration in the REPL,
;; because the REPL binds *out*.
;; It’s as if all the code you run in the REPL
;; is implicitly wrapped in something like
(comment (binding [*out* repl-printer] your-code))
;; If you create a new thread,
;; *out* won’t be bound to the REPL printer.

(.write *out* "show me in the repl!")
;; => nil
;; show me in the repl!

(comment
  (binding [*out* my-file-writer]
    (println "This goes into a file")))

;; See for a reference: clojure.core/with-out-str

(with-out-str
  (println "This doesn't go into REPL"))
;; (.write s# "This..")

;; "This doesn't go into REPL\n"
