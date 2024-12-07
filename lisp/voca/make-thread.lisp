(defparameter *counter* 0)

*counter*
;; 0

(defun test-update-global-variable ()
  (sb-thread:make-thread
   (lambda ()
     (sleep 1)
     (incf *counter*)))
  *counter*)

*counter*
;; 0

(test-update-global-variable)

*counter*
;; 1

(defun print-message-top-level-fixed ()
  (let ((top-level *standard-output*))
    (sb-thread:make-thread
     (lambda ()
       (format top-level "Hello from thread!"))))
  nil)

(print-message-top-level-fixed)
;; Hello from thread!
