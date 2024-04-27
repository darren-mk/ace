#lang racket/base



(require racket/set
         threading)


;; 1
;; ?

(equal? (f1 '(1 'a 2 'b 3 'c))
        (set '(1 2 3) '('a 'b 'c)))
(equal? (f1 '('a "foo"  "bar" 'b))
        (set '('a 'b) '("foo" "bar")))
(equal? (f1 '((1 2) 'a (3 4) 5 6 'b))
        (set '((1 2) (3 4)) '('a 'b) '(5 6)))
