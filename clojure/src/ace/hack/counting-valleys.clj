
(defn f [n s]
  (let [chars (seq s)]
    (if-not chars n
            (let [delta (case (first chars) \U 1 \D -1)]
              (f (+ n delta) (rest chars))))))

(defn countingValleys [steps path]
  (f 1 path))
