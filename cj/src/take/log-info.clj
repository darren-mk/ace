(require '[clojure.tools.logging :as log])

(log/info "test logging" {:a 1 :b 2})
;; => nil
;; Apr 19, 2021 9:35:20 AM clojure.tools.logging$eval5752$fn__5755 invoke
;; INFO: test logging {:a 1, :b 2}

(log/info "test logging" [1 "a" :c true])
;; => nil
;; Apr 19, 2021 9:36:21 AM clojure.tools.logging$eval5752$fn__5755 invoke
;; INFO: test logging [1 a :c true]
