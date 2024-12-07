(ex-info "message is that it's wrong!"
         {:first-name "darren"
          :error-cause "i don't know"})
;; => #error {
;;     :cause "message is that it's wrong!"
;;     :data {:first-name "darren", :error-cause "i don't know"}
;;     :via
;;     [{:type clojure.lang.ExceptionInfo
;;       :message "message is that it's wrong!"
;;       :data {:first-name "darren", :error-cause "i don't know"}
;;       :at [user$eval5448 invokeStatic "NO_SOURCE_FILE" 3]}]
;;     :trace
;;     [[user$eval5448 invokeStatic "NO_SOURCE_FILE" 3]
;;      [user$eval5448 invoke "NO_SOURCE_FILE" 3]
;;      [clojure.lang.Compiler eval "Compiler.java" 7177]
;;      [clojure.lang.Compiler eval "Compiler.java" 7132]
;;      [clojure.core$eval invokeStatic "core.clj" 3214]
;;      [clojure.core$eval invoke "core.clj" 3210]
;;      [nrepl.middleware.interruptible_eval$evaluate$fn__960$fn__961 invoke "interruptible_eval.clj" 87]
;;      [clojure.lang.AFn applyToHelper "AFn.java" 152]
;;      [clojure.lang.AFn applyTo "AFn.java" 144]
;;      [clojure.core$apply invokeStatic "core.clj" 665]
;;      [clojure.core$with_bindings_STAR_ invokeStatic "core.clj" 1973]
;;      [clojure.core$with_bindings_STAR_ doInvoke "core.clj" 1973]
;;      [clojure.lang.RestFn invoke "RestFn.java" 425]
;;      [nrepl.middleware.interruptible_eval$evaluate$fn__960 invoke "interruptible_eval.clj" 87]
;;      [clojure.main$repl$read_eval_print__9086$fn__9089 invoke "main.clj" 437]
;;      [clojure.main$repl$read_eval_print__9086 invoke "main.clj" 437]
;;      [clojure.main$repl$fn__9095 invoke "main.clj" 458]
;;      [clojure.main$repl invokeStatic "main.clj" 458]
;;      [clojure.main$repl doInvoke "main.clj" 368]
;;      [clojure.lang.RestFn invoke "RestFn.java" 1523]
;;      [nrepl.middleware.interruptible_eval$evaluate invokeStatic "interruptible_eval.clj" 84]
;;      [nrepl.middleware.interruptible_eval$evaluate invoke "interruptible_eval.clj" 56]
;;      [nrepl.middleware.interruptible_eval$interruptible_eval$fn__991$fn__995 invoke "interruptible_eval.clj" 152]
;;      [clojure.lang.AFn run "AFn.java" 22]
;;      [nrepl.middleware.session$session_exec$main_loop__1058$fn__1062 invoke "session.clj" 202]
;;      [nrepl.middleware.session$session_exec$main_loop__1058 invoke "session.clj" 201]
;;      [clojure.lang.AFn run "AFn.java" 22]
;;      [java.lang.Thread run "Thread.java" 829]]}

(def my-ex-info
 (ex-info "message is that it's wrong!"
          {:first-name "darren"
           :error-cause "i don't know"}))
;; => #'user/my-ex

(type my-ex-info)
;; => clojure.lang.ExceptionInfo

(ex-message my-ex-info)
;; => "message is that it's wrong!"

(ex-data my-ex-info)
;; => {:first-name "darren", :error-cause "i don't know"}

(throw my-ex-info)
;; 1. Unhandled clojure.lang.ExceptionInfo
;;    message is that it's wrong!
;;    {:first-name "darren", :error-cause "i don't know"}
;;                   AFn.java:  156  clojure.lang.AFn/applyToHelper
;;                   AFn.java:  144  clojure.lang.AFn/applyTo
;; ...


(.getMessage my-ex-info)
;; => "message is that it's wrong!"

(.getData my-ex-info)
;; => {:first-name "darren", :error-cause "i don't know"}
