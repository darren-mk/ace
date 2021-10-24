#lang racket/base

(require racket/string)

;; 2.2.4 Function Calls (Procedure Applications)

;; We have already seen many function calls, which
;; are called procedure applications in more traditional
;; terminology. The syntax of a function call is

;; +Function Calls (later in this guide) explains
;; more about function calls.

;;  ( ‹id› ‹expr›* )

;; where the number of ‹expr›s determines the number
;; of arguments supplied to the function named by ‹id›.

;; The racket language pre-defines many function identifiers,
;; such as substring and string-append. More examples are below.

;; In example Racket code throughout the documentation,
;; uses of pre-defined names are hyperlinked to the reference
;; manual. So, you can click on an identifier to get full
;; details about its use.

(string-append "rope" "twine" "yarn")  ; append strings
;; "ropetwineyarn"

(substring "corduroys" 0 4)            ; extract a substring
;; "cord"

(string-prefix? "shoelace" "shoe")     ; recognize string prefix/suffix
;; #t

(string-suffix? "shoelace" "shoe")
;; #f

(string? "Ceci n'est pas une string.") ; recognize strings
;; #t

(string? 1)
;; #f

(sqrt 16)                              ; find a square root
;; 4

(sqrt -16)
;; 0+4i

(+ 1 2)                                ; add numbers
;; 3

(- 2 1)                                ; subtract numbers
;; 1

(< 2 1)                                ; compare numbers
;; #f

(>= 2 1)
;; #t

(number? "c'est une number")           ; recognize numbers
;; #f

(number? 1)
;; #t

(equal? 6 "half dozen")                ; compare anything
;; #f

(equal? 6 6)
;; #t

(equal? "half dozen" "half dozen")
;; #t
