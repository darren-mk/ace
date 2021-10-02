#lang racket/base

2.4.1 Quoting Pairs and Symbols with quote

A list prints with a quote mark before it, but if an element of a list is itself a list, then no quote mark is printed for the inner list:

    > (list (list 1) (list 2 3) (list 4))

    '((1) (2 3) (4))

For nested lists, especially, the quote form lets you write a list as an expression in essentially the same way that the list prints:

    > (quote ("red" "green" "blue"))

    '("red" "green" "blue")
    > (quote ((1) (2 3) (4)))

    '((1) (2 3) (4))
    > (quote ())

    '()

The quote form works with the dot notation, too, whether the quoted form is normalized by the dot-parenthesis elimination rule or not:

    > (quote (1 . 2))

    '(1 . 2)
    > (quote (0 . (1 . 2)))

    '(0 1 . 2)

Naturally, lists of any kind can be nested:

    > (list (list 1 2 3) 5 (list "a" "b" "c"))

    '((1 2 3) 5 ("a" "b" "c"))
    > (quote ((1 2 3) 5 ("a" "b" "c")))

    '((1 2 3) 5 ("a" "b" "c"))

If you wrap an identifier with quote, then you get output that looks like an identifier, but with a ' prefix:

    > (quote jane-doe)

    'jane-doe

A value that prints like a quoted identifier is a symbol. In the same way that parenthesized output should not be confused with expressions, a printed symbol should not be confused with an identifier. In particular, the symbol (quote map) has nothing to do with the map identifier or the predefined function that is bound to map, except that the symbol and the identifier happen to be made up of the same letters.

Indeed, the intrinsic value of a symbol is nothing more than its character content. In this sense, symbols and strings are almost the same thing, and the main difference is how they print. The functions symbol->string and string->symbol convert between them.

Examples:

    > map

    #<procedure:map>
    > (quote map)

    'map
    > (symbol? (quote map))

    #t
    > (symbol? map)

    #f
    > (procedure? map)

    #t
    > (string->symbol "map")

    'map
    > (symbol->string (quote map))

    "map"

In the same way that quote for a list automatically applies itself to nested lists, quote on a parenthesized sequence of identifiers automatically applies itself to the identifiers to create a list of symbols:

    > (car (quote (road map)))

    'road
    > (symbol? (car (quote (road map))))

    #t

When a symbol is inside a list that is printed with ', the ' on the symbol is omitted, since ' is doing the job already:

    > (quote (road map))

    '(road map)

The quote form has no effect on a literal expression such as a number or string:

    > (quote 42)

    42
    > (quote "on the record")

    "on the record"
