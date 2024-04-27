#lang racket/base

;; 2.2.2 An Aside on Indenting Code

;; Line breaks and indentation are not significant for
;; parsing Racket programs, but most Racket programmers
;; use a standard set of conventions to make code more
;; readable. For example, the body of a definition is
;; typically indented under the first line of the definition.
;; Identifiers are written immediately after an open
;; parenthesis with no extra space, and closing parentheses
;; never go on their own line.

;; DrRacket automatically indents according to the standard
;; style when you type Enter in a program or REPL expression.
;; For example, if you hit Enter after typing (define (greet name),
;; then DrRacket automatically inserts two spaces for the next
;; line. If you change a region of code, you can select it in
;; DrRacket and hit Tab, and DrRacket will re-indent the code
;; (without inserting any line breaks). Editors like Emacs offer
;; a Racket or Scheme mode with similar indentation support.

;; Re-indenting not only makes the code easier to read, it
;; gives you extra feedback that your parentheses match in
;; the way that you intended. For example, if you leave out
;; a closing parenthesis after the last argument to a function,
;; automatic indentation starts the next line under the first
;; argument, instead of under the define keyword:

;; (define (halfbake flavor
;;                   (string-append flavor " creme brulee")))

;; In this case, indentation helps highlight the mistake.
;; In other cases, where the indentation may be normal while
;; an open parenthesis has no matching close parenthesis,
;; both racket and DrRacket use the source’s indentation to
;; suggest where a parenthesis might be missing.
