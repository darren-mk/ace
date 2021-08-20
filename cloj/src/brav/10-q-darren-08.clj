;; define a custom writer
;; hint: clojure.java.io namespace,
;; and make println write to a file

;; 1
(defn make-print-to-write-to-file-1 [file text]
  (with-open
    [writer
     (clojure.java.io/writer file :append true)]
    (->> text
         println
         with-out-str
         (.write writer))))
;; => #'user/make-print-to-write-to-file-1
(make-print-to-write-to-file-1
 "/tmp/test-make-print-to-write-to-file-1.txt"
 "hello, darren!")
;; => nil
