; https://leetcode.com/problems/defanging-an-ip-address/

(defn defanging-an-ip-address [address]
  (clojure.string/join 
   (map
    (fn [c] (if (= c \.) "[.]" c))
    (char-array address))))

(defanging-an-ip-address "1.1.1.1") ; returns "1[.]1[.]1[.]1"
(defanging-an-ip-address "255.100.50.0") ; returns "255[.]100[.]50[.]0"