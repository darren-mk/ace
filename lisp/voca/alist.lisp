(defparameter ages-good
  (list (cons 'john 34)
	(cons 'mary 23)
	(cons 'tim 72)))

(defparameter ages-unsure
  (list (cons 'john 34)
	(cons 'mary 23)
	(cons 'mary 72)))

;; comparison against hashtable
(time
 (assoc 'abc (list (cons 'bbb1 111)
                   (cons 'bbb2 111)
                   (cons 'bbb3 111)
                   (cons 'bbb4 111)
                   (cons 'bbb5 111)
                   (cons 'bbb6 111)
                   (cons 'bbb7 111)
                   (cons 'bbb8 111)
                   (cons 'bbb9 111)
                   (cons 'abc 123))))
;;Evaluation took:
;;  0.000 seconds of real time
;;  0.000002 seconds of total run time (0.000002 user, 0.000000 system)
;;  100.00% CPU
;;  0 bytes consed
(time
 (gethash 'abc
          (serapeum:dict 'qqq 1
                         'wwww 2
                         'eee 3
                         'ttt 5
                         'yyy 6
                         'uuu 6
                         'aaa 4
                         'sss 4
                         'fff 6
                         'abc 123)))
;; Evaluation took:
;;  0.000 seconds of real time
;;  0.000005 seconds of total run time (0.000004 user, 0.000001 system)
;;  100.00% CPU
;;  0 bytes consed
