;; clojure.core.async/alt!
;; ([& clauses])
;; Macro
;; Makes a single choice between one of several channel operations,
;; as if by alts!, returning the value of the result expr corresponding
;; to the operation completed. Must be called inside a (go ...) block.
;; Each clause takes the form of:
;; channel-op[s] result-expr
;; where channel-ops is one of:
;; take-port - a single port to take
;; [take-port | [put-port put-val] ...] - a vector of ports as per alts!
;; :default | :priority - an option for alts!
;; and result-expr is either a list beginning with a vector, whereupon that
;; vector will be treated as a binding for the [val port] return of the
;; operation, else any other expression.
(comment 
  (alt!
    [c t] ([val ch] (foo ch val))
    x ([v] v)
    [[out val]] :wrote
    :default 42))
;; Each option may appear at most once. The choice and parking
;; characteristics are those of alts!.

(require '[clojure.core.async :as a])

;; WRITE MY OWN EXAMPLES
