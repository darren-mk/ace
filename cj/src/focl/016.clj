(ns focl.016)

;; Hello World
;; Difficulty:	Elementary
;; Topics:	
;; Write a function which returns a personalized greeting.
;; (= (__ "Dave") "Hello, Dave!")
;; (= (__ "Jenn") "Hello, Jenn!")
;; (= (__ "Rhea") "Hello, Rhea!")

(= ((fn [name] (str "Hello, " name "!")) "Dave") "Hello, Dave!") ;; => true
(= (#(str "Hello, " % "!") "Jenn") "Hello, Jenn!") ;; => true
(= (#(str "Hello, " % "!") "Rhea") "Hello, Rhea!") ;; => true
