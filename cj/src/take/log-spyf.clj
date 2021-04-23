(require '[clojure.tools.logging :as log])

(log/spyf :info "test warning")
;; => "test warning"
