#lang typed/racket

(struct document
  ([author : String]
   [title : String]
   [content : String]))

(struct book
  document
  ([publisher : String])
  #:transparent)

(define my-book
  (book "Darren Kim"
        "Core Async"
        "tutorials"
        "Bitem"))

#|
my-book
- : book
(book ... "Bitem")

struct.rkt> (book-publisher my-book)
- : String
"Bitem"

struct.rkt> (document-author my-book)
- : String
"Darren Kim"
|#
