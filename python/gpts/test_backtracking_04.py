# Q4 — Given digits 2–9, return all possible letter combinations
# Phone keypad mapping:
# 2 → abc
# 3 → def
# 4 → ghi
# 5 → jkl
# 6 → mno
# 7 → pqrs
# 8 → tuv
# 9 → wxyz
# Example:
# Input:
# "23"
# Output (order doesn't matter):
# ["ad","ae","af","bd","be","bf","cd","ce","cf"]
# Requirements
# Use backtracking.
# One character is chosen from the mapping for each digit.
# Empty input → return empty list [].

mapping = {
    "2": ["a", "b", "c"],
    "3": ["d", "e", "f"],
    "4": ["g", "h", "i"],
    "5": ["j", "k", "l"],
    "6": ["m", "n", "o"],
    "7": ["p", "q", "r", "s"],
    "8": ["t", "u", "v"],
    "9": ["w", "x", "y", "z"],}

def letter_combinations(s):
    res = []
    def go(s, acc):
        if not s:
            if acc:
                res.append(acc)
            return
        for letter in mapping[s[0]]:
            go(s[1:], acc+letter)
    go(s, '')
    return res

def test_letter_combinations():
    out = letter_combinations("")
    assert out == []
    out = sorted(letter_combinations("2"))
    assert out == sorted(["a", "b", "c"])
    out = sorted(letter_combinations("23"))
    assert out == sorted([
        "ad","ae","af",
        "bd","be","bf",
        "cd","ce","cf" ])