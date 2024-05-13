(defun half (x)
  (/ x 2))

(trace half)

(half 7)
;; 0: (HALF 7)
;; 0: HALF returned 7/2
;; 7/2 (3.5)

(defun avg (x y)
  (+ (half x) (half y)))

(trace avg)
;; 0: (AVG 10 20)
;; 1: (HALF 10)
;; 1: HALF returned 5
;; 1: (HALF 20)
;; 1: HALF returned 10
;; 0: AVG returned 15
;; 15 (4 bits, #xF, #o17, #b1111)

(untrace half avg)

(avg 10 20)
;; 15 (4 bits, #xF, #o17, #b1111)
