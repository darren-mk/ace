

(doc reify)

;; https://stuartsierra.com/2015/05/27/clojure-uncaught-exceptions
;; Assuming require [clojure.tools.logging :as log]
(comment 
  (Thread/setDefaultUncaughtExceptionHandler
   (reify Thread$UncaughtExceptionHandler
     (uncaughtException [_ thread ex]
       (log/error ex "Uncaught exception on" (.getName thread)))))
  )


