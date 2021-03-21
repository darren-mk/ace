;; #126
;; Through the Looking Class
;; Difficulty: Easy
;; Topics: fun brain-teaser
;; Enter a value which satisfies the following:
;; (let [x __] (and (= (class x) x) x))

;; trial 1
(let [x Class]
  (and (= (class x) x)
       x))
