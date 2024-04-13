;; https://4clojure.oxal.org/#/problem/74

(require '[clojure.string :as cstr])
(require '[clojure.math :as cm])

(defn f1 [s]
  (->> (cstr/split s #",")
       (map #(Integer/parseInt %))
       (filter #(zero? (- (cm/sqrt %) (int (cm/sqrt %)))))
       (map str)
       (cstr/join ",")))
(= (f1 "4,5,6,7,8,9") "4,9")
:=> true
(= (f1 "15,16,25,36,37") "16,25,36")
:=> true
