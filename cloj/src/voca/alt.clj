(ns voca.alt
  (:require [clojure.core.async :as a]))

;; basics 1
(def c1 (a/chan))
(def c2 (a/chan))
(def switch (atom true))
(a/go (while @switch
        (let [[v ch] (a/alts! [c1 c2])]
          (println "reads" v "from" ch))))
(a/go (a/>! c1 "yo!"))
(a/go (a/>! c2 "ye!"))
(a/close! c1)
(a/close! c2)
(swap! switch not)
