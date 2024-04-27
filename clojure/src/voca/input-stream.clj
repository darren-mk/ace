(require '[clojure.java.io :as io])
;; => nil

(io/input-stream "/home/drnmk/Documents/ace/readme.md")
;; => #object[java.io.BufferedInputStream 0x4a2156b8 "java.io.BufferedInputStream@4a2156b8"]

(slurp (io/input-stream "/home/drnmk/Documents/ace/readme.md"))
;; => "# Working to \"ace\" algorithm challenges!\n## Currently working on\n* leetcode (\"leet\")\n* 4clojure (\"focl\")\n* codility (\"codi\")\n## Idioms are summarized in\n* takeaways (\"take\")\n## In multiple languages including\n* Clojure (\"cj\")\n* Python (\"py\")\n* F# (\"fs\")\n* Haskell (\"hs\")\n* Racket (\"rs\")\n* Java (\"jv\")\n"
