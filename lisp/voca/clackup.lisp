(ql:quickload :clack)
(ql:quickload :woo)

(defvar *app*
  (lambda (env)
    (print "yay!")
    (print "ho")
    '(200 (:content-type "text/plain")
      ("Hello, Clack!"))))

(defvar server
  (clack:clackup *app*
		 :server :woo
		 :port 5050))


(clack:stop server)

;; Woo server is started.
;; Listening on 127.0.0.1:5050.
