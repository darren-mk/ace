;; If the difference between the  and the next multiple of  is less than , round  up to the next multiple of .
;; If the value of  is less than , no rounding occurs as the result will still be a failing grade.

(defn nm [x mul]
  (loop [x x]
    (if (zero? (mod x mul))
      x
      (recur (inc x)))))

(defn f [grade]
  (if (< grade 38)
    grade
    (let [nm-5 (nm grade 5)
          diff (- nm-5 grade)]
      (if (< diff 3)
        nm-5
        grade))))

(defn gradingStudents [grades]
  (map f grades))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def grades-count (Integer/parseInt (clojure.string/trim (read-line))))

(def grades [])

(doseq [_ (range grades-count)]
    (def grades (conj grades (Integer/parseInt (clojure.string/trim (read-line))))))

(def result (gradingStudents grades))

(spit fptr (clojure.string/join "\n" result) :append true)
(spit fptr "\n" :append true)
