;; exemplify gensym

(gensym)
;; => G__6436

(gensym abc)
;; error

(gensym 'abc)
;; => abc6455

`(let [~(gensym 'coin) "be rich"]
   ~(gensym 'coin))
;; => (clojure.core/let [coin6466 "be rich"] coin6467)
(eval
 `(let [~(gensym 'coin) "be rich"]
    ~(gensym 'coin)))
;; error
;; as the numberings aren't matched

`(let [coin# "be rich"]
   coin#)
;; => (clojure.core/let [coin__6478__auto__ "be rich"] coin__6478__auto__)
(eval
 `(let [coin# "be rich"]
    coin#))
;; => "be rich"
