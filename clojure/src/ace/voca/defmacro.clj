(ns ace.voca.defmacro
  (:require
   [clojure.test :as t]
   [clojure.core.async :as a]))

(defmacro unless [b & body]
  `(when (not ~b) ~@body))

(t/deftest unless-test
  (t/is (= 1 (unless false 1)))
  (t/is (= nil (unless true 1)))
  (t/is (= (macroexpand-1 '(unless x (prn :hi) 42))
           '(clojure.core/when (clojure.core/not x) (prn :hi) 42))))

(defmacro dbg [exp]
  (let [v# (gensym 'v)] 
    `(let [~v# ~exp]
       (print '~exp "=>" ~v#)
       ~v#)))

(t/deftest dbg-test
  (t/is (= 3 (dbg (+ 1 2)))))

(defmacro whenever [b & body]
  `(if ~b (do ~@body) nil))

(t/deftest whenever-test
  (let [x (atom nil)
        f #(reset! x %)]
    (t/is (= 1 (whenever true (f 7) 1)))
    (t/is (= 7 @x))
    (t/is (nil? (whenever false (f -8) 1)))
    (t/is (= 7 @x))))

(defmacro orer
  ([] nil)
  ([x] x)
  ([x & xs]
   `(let [v# ~x]
      (if v# v#
          (orer ~@xs)))))

(t/deftest orer-test
  (t/is (= 7 (orer nil false 7))))

(defmacro ander
  ([] true)
  ([x] x)
  ([x & xs]
   `(let [v# ~x]
      (if-not v# v#
              (ander ~@xs)))))

(t/deftest ander-test
  (t/is (= true (ander)))
  (t/is (= 1 (ander 1)))
  (t/is (= 3 (ander true 2 3)))
  (t/is (nil? (ander 1 nil 3)))
  (t/is (= false (ander 1 false 3)))
  (let [x (atom 0)]
    (t/is (nil? (ander true nil (swap! x inc))))
    (t/is (= 0 @x)))
  (let [x (atom 0)]
    (t/is (= false (ander true false (swap! x inc))))
    (t/is (= 0 @x)))
  (let [x (atom 0)
        bump (fn [v] (swap! x inc) v)]
    (t/is (= 7 (ander (bump true) (bump 7))))
    (t/is (= 2 @x))))

(defmacro leter [sym exp & body]
  `(let [~sym ~exp] ~@body))

(t/deftest leter-test
  (t/is (= 30 (leter ^:clj-kondo/ignore x
                  (+ 1 2) (* ^:clj-kondo/ignore x 10))))
  (t/is (= 7 (leter ^:clj-kondo/ignore x 1
               (inc ^:clj-kondo/ignore x)
               (+ ^:clj-kondo/ignore x 6))))
  (let [cnt (atom 0)
        mk  (fn [] (swap! cnt inc) 5)]
    (t/is (= 6 (leter ^:clj-kondo/ignore x (mk)
                 (inc ^:clj-kondo/ignore x))))
    (t/is (= 1 @cnt)))
  (let [x 100]
    (t/is (= 3 (leter ^:clj-kondo/ignore x 3 x)))
    (t/is (= 100 x)))
  (t/is (= :ok (leter ^:clj-kondo/ignore x 42 :ok))))

(defmacro when-leter [sym exp & body]
  `(let [~sym ~exp]
     (when ~sym ~@body)))

(t/deftest when-leter-test
  (t/is (= 4 (when-leter ^:clj-kondo/ignore x 3
                         (+ ^:clj-kondo/ignore x 1))))
  (let [called? (atom false)]
    (t/is (nil? (when-leter ^:clj-kondo/ignore x nil
                            (reset! called? true)
                            42)))
    (t/is (= false @called?)))
  (let [cnt (atom 0)
        mk  (fn [] (swap! cnt inc) 10)]
    (t/is (= 11 (when-leter ^:clj-kondo/ignore x (mk)
                            (+ ^:clj-kondo/ignore x 1))))
    (t/is (= 1 @cnt)))
  (t/is (= 6 (when-leter ^:clj-kondo/ignore x 2
                         (inc ^:clj-kondo/ignore x)
                         (* ^:clj-kondo/ignore x 3)))))

(defmacro with-leter [[sym exp] & body]
  `(let [~sym ~exp]
     ~@body))

(t/deftest with-leter-test
  (t/is (= 30 (with-leter [^:clj-kondo/ignore x (+ 1 2)]
                (* ^:clj-kondo/ignore x 10)))))

(defmacro assert! [exp msg]
  `(let [v# ~exp]
     (when-not v#
       (throw (ex-info ~msg {:test '~exp})))))

(t/deftest assert!-test
  (t/testing "pass" 
    (t/is (nil? (assert! (= 1 1) "should pass"))))
  (t/testing "fail" 
    (try
      (assert! (= 1 2) "math broke")
      (t/is false "expected assert! to throw")
      (catch clojure.lang.ExceptionInfo e
        (let [d (ex-data e)]
          (t/is (= "math broke" (.getMessage e)))
          (t/is (= '(= 1 2) (:test d)))))))
  (t/testing "evaluate only once"
    (let [cnt (atom 0)
          pred (fn [] (swap! cnt inc) false)]
      (try
        (assert! (pred) "boom")
        (t/is false "expected assert! to throw")
        (catch clojure.lang.ExceptionInfo _))
      (t/is (= 1 @cnt)))))

(defmacro assert= [a b msg]
  `(let [a# ~a b# ~b]
     (when (not= a# b#)
       (throw (ex-info ~msg
                       {:a-form '~a 
                        :b-form '~b
                        :a-val a#
                        :b-val b#})))))

(t/deftest assert=-test
  (t/testing "pass" 
    (t/is (nil? (assert= 3 (+ 1 2) "should pass"))))
  (t/testing "fail"
    (try
      (assert= (+ 1 2) 10 "bad math")
      (t/is false "expected assert= to throw")
      (catch clojure.lang.ExceptionInfo e
        (let [d (ex-data e)]
          (t/is (= "bad math" (.getMessage e)))
          (t/is (= '(+ 1 2) (:a-form d)))
          (t/is (= '10 (:b-form d)))
          (t/is (= 3 (:a-val d)))
          (t/is (= 10 (:b-val d))))))))
