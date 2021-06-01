;; https://www.geeksforgeeks.org/binary-search/

(define (range start end)
  (if (< end start)
      null
      (cons start (range (add1 start) end))))
