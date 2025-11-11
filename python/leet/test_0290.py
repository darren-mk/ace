from typing import Dict, List

class Solution:
    def detach_to_chars(self, s: str) -> List[str]:
        chars: List[str] = []
        for c in s:
            chars.append(c)
        return chars
    def detach_to_words(self, phrase: str) -> List[str]:
        words: List[str] = []
        last_word: List[str] = []
        for c in phrase:
            if c == ' ':
                words.append("".join(last_word))
                last_word = []
            else:
                last_word.append(c)
        words.append("".join(last_word))
        return words
    def wordPattern(self, pattern: str, s: str) -> bool:
        pattern_chars: List[str] = self.detach_to_chars(pattern)
        s_words: List[str] = self.detach_to_words(s)
        pattern_chars_len: int = len(pattern_chars)
        if pattern_chars_len != len(s_words):
            return False
        mapping_pattern_to_word: Dict[str, str] = {}
        mapping_word_to_pattern: Dict[str, str] = {}
        for i in range(pattern_chars_len):
            word_found = mapping_pattern_to_word.get(pattern_chars[i])            
            if word_found and word_found != s_words[i]:
                return False
            pattern_found = mapping_word_to_pattern.get(s_words[i])
            if pattern_found and pattern_found != pattern_chars[i]:
                return False
            mapping_pattern_to_word[pattern_chars[i]] = s_words[i]
            mapping_word_to_pattern[s_words[i]] = pattern_chars[i]
        return True

def test_a():
    sol = Solution()
    assert sol.detach_to_chars('abba') == ['a', 'b', 'b', 'a']
    assert sol.detach_to_words('dog cat cat dog') == ['dog', 'cat', 'cat', 'dog']
    assert sol.wordPattern('abba', 'dog cat cat dog') == True
    assert sol.wordPattern('abba', 'dog dog dog dog') == False