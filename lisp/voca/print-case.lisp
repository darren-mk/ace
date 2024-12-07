(ql:quickload '(:jonathan))

(setf *print-case* :upcase)
(jonathan:to-json '((:result . "authorized")) :from :alist)
;; "{\"RESULT\":\"authorized\"}"

(setf *print-case* :downcase)
(jonathan:to-json '((:result . "authorized")) :from :alist)
;; "{\"result\":\"authorized\"}"
