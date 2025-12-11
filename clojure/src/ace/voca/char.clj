(char 97) ;; => \a
(->> [67 108 111 106 117 114 101]
     (map char)
     (apply str)) ;; => "Clojure"
