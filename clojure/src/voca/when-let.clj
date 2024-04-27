;; clojure.core/when-let
;; ([bindings & body])
;; Macro
;; bindings => binding-form test
;; When test is true, evaluates body with binding-form bound to the value of test
;; Spec
;; args: (cat :bindings (and vector? :clojure.core.specs.alpha/binding) :body (* any?))
;; ret: any?

(when-let [v (/ 4 2)]
  (inc v)) ;; => 3

(when-let [v (try (/ 2 0)
                  (catch Exception e))]
  (inc v)) ;; => nil
