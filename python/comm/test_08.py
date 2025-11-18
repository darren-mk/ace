from enum import Enum
from typing import List, Optional

class Bracket(Enum):
    ROUND = "()"
    SQUARE = "[]"
    CURLY = "{}"

OPENING = "([{"
CLOSING = ")]}"

def test_bracket_type():
    assert bracket_type('{') == Bracket.CURLY
    assert bracket_type('[') == Bracket.SQUARE
    assert bracket_type('(') == Bracket.ROUND
    assert bracket_type('}') == Bracket.CURLY

def bracket_type(c: str) -> Bracket:
    for b in Bracket:
        if c in b.value:
            return b
    raise ValueError(f"Not a bracket: {c}")

class Linter:
    def __init__(self) -> None:
        self.stack: List[Bracket] = []
    def _push(self, b: Bracket) -> None:
        self.stack.append(b)
    def _top(self) -> Optional[Bracket]:
        return self.stack[-1] if self.stack else None
    def _pop(self) -> Optional[Bracket]:
        return self.stack.pop() if self.stack else None
    def check(self, code: str) -> bool:
        # reset stack each call so one check doesn't affect the next
        self.stack.clear()
        for c in code:
            if c in OPENING:
                self._push(bracket_type(c))
            elif c in CLOSING:
                top = self._top()
                if top is None:
                    return False  # closing without opening
                if bracket_type(c) != top:
                    return False  # mismatched type
                self._pop()
        # valid only if no unclosed brackets
        return not self.stack

def test_linter_valid():
    l = Linter()
    assert l.check("(var x = {y: [1, 2, 3]})")
    assert l.check("()")
    assert l.check("[]{}()")
    assert l.check("if { return; }")
    assert not l.check("}{")
    assert not l.check("(")
    assert not l.check("([)]")
    assert not l.check("([)")    