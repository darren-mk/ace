# Backtracking Exercise A
# Function name: generate_strings
# Problem:
# Given:
# alphabet: list of characters (e.g. ['a','b','c'])
# n: integer
# Return all strings of length n formed from the alphabet.
# Example:
# Input:
# alphabet = ['a','b']
# n = 2
# Output (order doesn’t matter):
# ['aa','ab','ba','bb']

def generate_strings(alphabet, n):
    res = []
    def go(start, acc):
        if start == n:
            res.append(acc[:])
            return
        for c in alphabet:
            acc.append(c)
            go(start+1, acc)
            acc.pop()
    go(0,[])
    return res

generate_strings(['a','b'],2)