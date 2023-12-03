

(defn search-unordered-array
  ([ua v] (search-unordered-array ua v (count ua) 0))
  ([ua v len i]
   (cond (<= len i) nil
         (= v (get ua i)) i
         :else (search-unordered-array ua v len (inc i)))))
(search-unordered-array
 [17 3 75 202 80] 75) ;; 2
(search-unordered-array
 [17 3 75 202 80] 23) ;; nil

(defn search-ordered-array-linear
  ([oa v]
   (search-ordered-array-linear
    oa v (count oa) 0))
  ([oa v len i]
   (cond (<= len i) nil
         (< v (get oa i)) nil
         (= v (get oa i)) i
         :else (search-ordered-array-linear
                oa v len (inc i)))))
(search-ordered-array-linear
 [3 17 75 80 202] 75) ;; 2
(search-ordered-array-linear
 [3 17 75 80 202] 23) ;; nil

(defn search-ordered-array-binary
  ([oa v]
   (search-ordered-array-binary oa v 0 (dec (count oa))))
  ([oa v start-ind end-ind]
   (let [mid-i (int (/ (- end-ind start-ind) 2))
         mid-v (get oa mid-i)]
     (println "mid-i" mid-i)
     (cond (= v mid-v) mid-i
           (< v mid-v) (search-ordered-array-binary oa v start-ind mid-i)
           (> v mid-v) (search-ordered-array-binary oa v mid-i end-ind)
           :else nil))))
;;;;;;; not working - need to work
(search-ordered-array-binary
 [1 2 3 6 7 9 13 15 17 22 24 28 29] 3)
