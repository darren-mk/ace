;; https://leetcode.com/problems/longest-substring-without-repeating-characters/

;; 1
(defn f1 [s]
  (->> (reduce
        (fn [acc char]
          (if (clojure.string/includes? acc (str char))
            acc
            (str acc char)))
        "" s)
       count))
(= 3 (f1 "abcabcbb")) ;; => true
(= 1 (f1 "bbbbb")) ;; => true
(= 3 (f1 "pwwkew")) ;; => false
(= 0 (f1 "")) ;; => true
