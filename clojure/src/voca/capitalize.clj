(require '[clojure.string :as cstr])

(cstr/capitalize "abc") ;; => "Abc"

(def lower-chars
  (map char (range 97 123)))

(def upper-chars
  (map char (range 65 91)))

(def mapper
  (apply
   merge
   (map (fn [lower upper]
          {lower upper})
  lower-chars
  upper-chars)))

(defn capitalize' [s]
  (map #(if (contains? (set lower-chars) %)
          (get mapper %) %)
       (seq (char-array s))))

(capitalize' "aBcdEfg")
;; => (\A \B \C \D \E \F \G)
