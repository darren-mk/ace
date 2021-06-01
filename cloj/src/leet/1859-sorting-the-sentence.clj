;; https://leetcode.com/problems/sorting-the-sentence/

;; 1
(defn f1 [s]
  (->> (clojure.string/split s #" ")
    (map (fn [x] {:position (last x) :value x}))
    (sort-by :position)
    (map :value)
    (map #(-> % butlast clojure.string/join))
    (clojure.string/join #" ")))

(= (f1 "is2 sentence4 This1 a3")
   "This is a sentence") ;; => true
(= (f1 "Myself2 Me1 I4 and3")
   "Me Myself and I") ;; => true

;; 2
(def nums-in-str
  (into #{} (map str (range 10))))
(defn f2 [s]
  (loop [source (map str s)
         words []
         word {}]
    (cond
      ;; when no more letter
      (nil? (first source)) words
      ;; when number
      (contains? nums-in-str (first source))
      (recur (rest source)
             words
             {(Integer. (first source)) (val word)})
      ;; when blank
      (= (first source) " ")
      (recur (rest source)
             (conj words word)
             {0 ""})
      ;; all else - when alphabet
      :else
      (recur (rest source)
             words
             {(key word)
              (str (val word) (first source))}))))

(= (f2 "is2 sentence4 This1 a3")
   "This is a sentence") ;; NOT WORKING
(= (f2 "Myself2 Me1 I4 and3")
   "Me Myself and I") ;; NOT WORKING
