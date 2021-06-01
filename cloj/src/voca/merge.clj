;; merge
(merge {:a 1 :b 3} {:b 9 :d 4}) ;; => {:a 1, :b 9, :d 4}

;; for vector, works like conj
(merge [1 2] 3) ;; => [1 2 3]
(conj [1 2] 3) ;; => [1 2 3]
