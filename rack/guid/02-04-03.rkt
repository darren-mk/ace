#lang racket/base

2.4.3 Lists and Racket Syntax

Now that you know the truth about pairs and lists, and now that you’ve seen quote, you’re ready to understand the main way in which we have been simplifying Racket’s true syntax.

The syntax of Racket is not defined directly in terms of character streams. Instead, the syntax is determined by two layers:

    a reader layer, which turns a sequence of characters into lists, symbols, and other constants; and

    an expander layer, which processes the lists, symbols, and other constants to parse them as an expression.

The rules for printing and reading go together. For example, a list is printed with parentheses, and reading a pair of parentheses produces a list. Similarly, a non-list pair is printed with the dot notation, and a dot on input effectively runs the dot-notation rules in reverse to obtain a pair.

One consequence of the read layer for expressions is that you can use the dot notation in expressions that are not quoted forms:

    > (+ 1 . (2))

    3

This works because (+ 1 . (2)) is just another way of writing (+ 1 2). It is practically never a good idea to write application expressions using this dot notation; it’s just a consequence of the way Racket’s syntax is defined.

Normally, . is allowed by the reader only with a parenthesized sequence, and only before the last element of the sequence. However, a pair of .s can also appear around a single element in a parenthesized sequence, as long as the element is not first or last. Such a pair triggers a reader conversion that moves the element between .s to the front of the list. The conversion enables a kind of general infix notation:

    > (1 . < . 2)

    #t
    > '(1 . < . 2)

    '(< 1 2)

This two-dot convention is non-traditional, and it has essentially nothing to do with the dot notation for non-list pairs. Racket programmers use the infix convention sparingly—mostly for asymmetric binary operators such as < and is-a?.
