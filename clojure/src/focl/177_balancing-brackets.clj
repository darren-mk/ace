;; https://4clojure.oxal.org/#/problem/177


;; 1



(defn f1 [s]
  (loop [l (seq (char-array s))
         paren 0
         curly 0
         square 0]
    (cond (empty? l) [paren curly square] ;; (= 0 paren curly square)
          (= \( (first l)) (recur (rest l) (inc paren) curly square)
          (= \) (first l)) (recur (rest l) (dec paren) curly square)
          (= \{ (first l)) (recur (rest l) paren (inc curly) square)
          (= \} (first l)) (recur (rest l) paren (dec curly) square)
          (= \[ (first l)) (recur (rest l) paren curly (inc square))
          (= \] (first l)) (recur (rest l) paren curly (dec square))
          :else (recur (rest l) paren curly square)))) 

(seq (char-array "(start, end]"))

(f1 "This string has no brackets.")
(f1 "class Test {
                          public static void main(String[] args) {
                            System.out.println(\"Hello world.\");
                          }
                        }")
(not (f1 "(start, end]"))
(not (f1 "())"))
(not (f1 "[ { ] } "))
(f1 "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))")
(not (f1 "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))"))
(not (f1 "["))
