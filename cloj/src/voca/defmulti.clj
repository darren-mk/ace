;; 1
(defmulti operate-two-nums 
  (fn [operation _ _] operation))
;; => nil
(defmethod operate-two-nums :multiply-and-add-100
  [_ x y]
  (+ (* x y) 100))
;; => #multifn[operate-two-nums 0x5085143d]
(defmethod operate-two-nums :multiply-and-subtract-50
  [_ x y]
  (- (* x y) 50))
;; => #multifn[operate-two-nums 0x5085143d]
(operate-two-nums :multiply-and-add-100 300 200)
;; => 60100
(operate-two-nums :multiply-and-subtract-50 300 200)
;; => 59950
