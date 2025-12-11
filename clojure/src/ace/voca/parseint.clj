(Integer/parseInt "1011" 2)
;; => 11

(Integer/parseInt "44" 5)
;; => 24

(Integer/parseInt "44")
;; => 44

;; (Integer/parseInt "129834710892374102839471028394723424234")
;; fails, but
;; (read-string "129834710892374102839471028394723424234")
;; succeeds
