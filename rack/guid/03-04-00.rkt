#lang racket/base

;; 3.4 Strings (Unicode)

#| A string is a fixed-length array of characters. 
It prints using double quotes, where double quote 
and backslash characters within the string are 
escaped with backslashes. Other common string escapes 
are supported, including \n for a linefeed, \r for 
a carriage return, octal escapes using \ followed by 
up to three octal digits, and hexadecimal escapes 
with \u (up to four digits). Unprintable characters 
in a string are normally shown with \u when the 
string is printed. |#

#| +Reading Strings in The Racket Reference documents 
the fine points of the syntax of strings. |#

#| The display procedure directly writes the characters 
of a string to the current output port (see Input and 
Output), in contrast to the string-constant syntax used 
to print a string result. |#

;; Examples:

"Apple"
;; "Apple"

"\u03BB"
;; "λ"

(display "Apple")
;; Apple

(display "a \"quoted\" thing")
;; a "quoted" thing

(display "two\nlines")
;; two
;; lines

(display "\u03BB")
;; λ

#| A string can be mutable or immutable; strings written 
directly as expressions are immutable, but most other 
strings are mutable. The make-string procedure creates 
a mutable string given a length and optional fill character. 
The string-ref procedure accesses a character from a string 
(with 0-based indexing); the string-set! procedure changes 
a character in a mutable string. |#

;; Examples:

(string-ref "Apple" 0)
;; #\A

(define s (make-string 5 #\.))
s
;; "....."

(string-set! s 2 #\λ)
s
;; "..λ.."

#| String ordering and case operations are generally 
locale-independent; that is, they work the same for all 
users. A few locale-dependent operations are provided that 
allow the way that strings are case-folded and sorted to 
depend on the end-user’s locale. If you’re sorting strings, 
for example, use string<? or string-ci<? if the sort result 
should be consistent across machines and users, but use 
string-locale<? or string-locale-ci<? if the sort is purely 
to order strings for an end user. |#

;; Examples:

(string<? "apple" "Banana")
;; #f

(string>? "apple" "Banana")
;; #t

(string-ci<? "apple" "Banana")
;; #t

(string-upcase "Straße")
;; "STRASSE"

(parameterize ([current-locale "C"])
  (string-locale-upcase "Straße"))
;; "STRAßE"

#| For working with plain ASCII, working with raw bytes, 
or encoding/decoding Unicode strings as bytes, use 
byte strings. |#

#| +Strings in The Racket Reference provides more on strings 
and string procedures. |#
