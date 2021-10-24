#lang racket/base

;; A program module is written as
;; #lang ‹langname› ‹topform›*

;; where a ‹topform› is either a ‹definition› or an ‹expr›.
;; The REPL also evaluates ‹topform›s.

;; In syntax specifications, text with a gray background,
;; such as #lang, represents literal text. Whitespace must
;; appear between such literals and nonterminals like ‹id›,
;; except that whitespace is not required before or after
;; (, ), [, or ]. A comment, which starts with ; and runs
;; until the end of the line, is treated the same as whitespace.

;; Reading Comments in The Racket Reference provides
;; more on different forms of comments.

;; Following the usual conventions, * in a grammar means
;; zero or more repetitions of the preceding element,
;; + means one or more repetitions of the preceding element,
;; and {} groups a sequence as an element for repetition.
