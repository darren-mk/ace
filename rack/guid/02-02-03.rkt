#lang racket/base

#|
2.2.3 Identifiers

Racket’s syntax for identifiers is especially liberal. 
Excluding the special characters

+ Identifiers and Binding (later in this guide) 
  explains more about identifiers.

   ( ) [ ] { } " , ' ` ; # | \

and except for the sequences of characters that make 
number constants, almost any sequence of non-whitespace 
characters forms an ‹id›. For example substring is an 
identifier. Also, string-append and a+b are identifiers, 
as opposed to arithmetic expressions. Here are several 
more examples:

    +
    integer?
    pass/fail
    Hfuhruhurr&Uumellmahaye
    john-jacob-jingleheimer-schmidt
    a-b-c+1-2-3
|#
