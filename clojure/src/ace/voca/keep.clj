(ns ace.voca.keep
  (:require
   [clojure.test :as t]))

;; clojure.core/keep
;; ([f] [f coll])
;; Returns a lazy sequence of the non-nil results of (f item). Note,
;; this means false return values will be included.  f must be free of
;; side-effects.  Returns a transducer when no collection is provided.

(t/deftest keep-basics-test
  (t/is (= '(2 3 4)
           (keep inc (range 1 4)))))
