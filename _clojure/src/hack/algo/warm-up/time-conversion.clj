;; https://www.hackerrank.com/challenges/time-conversion

;; 1
(defn f1 [s]
  (let [am-or-pm (apply str (take-last 2 s))
        hour-raw-int (Integer/parseInt (apply str (take 2 s)))
        hour-int (cond
                   (and (= am-or-pm "AM")
                        (= hour-raw-int 12)) 0
                   (= am-or-pm "AM") hour-raw-int
                   (and (= am-or-pm "PM")
                        (= hour-raw-int 12)) 12
                   (= am-or-pm "PM") (+ hour-raw-int 12))
        hour (if (< hour-int 10)
               (str "0" hour-int)
               (str hour-int))
        minute (apply str (take-last 2 (take 5 s)))
        sec (apply str (take-last 2 (take 8 s)))]
    (str hour ":" minute ":" sec)))
(= "19:05:45" (f1 "07:05:45PM")) ;; => true
(= "07:05:45" (f1 "07:05:45AM")) ;; => true
(= "00:05:39" (f1 "12:05:39AM")) ;; => true
(= "12:45:54" (f1 "12:45:54PM")) ;; => true
