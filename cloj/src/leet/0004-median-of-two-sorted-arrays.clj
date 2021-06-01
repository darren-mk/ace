;; https://leetcode.com/problems/median-of-two-sorted-arrays/


(concat [1 2] [3 4])
;; => (1 2 3 4)

(count [1 2 3])
;; => 3

(get [:a :b :c] 1)

(defn f1 [a b]
  (let [combined (concat a b)
        sorted (sort combined)
        len (count sorted)
        ]
    (if (odd? len)
      (get sorted (/ len 2))
      (/ (get sorted (/ )))

      )

    )

  )
