from typing import Dict, List, Optional, Set

class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class SolutionA:
    def cloneGraph(self, node: Optional[Node]) -> Optional[Node]:
        if not node: return
        copied = {}
        def go(start: Optional[None]):
            if start in copied: return copied[start]
            clone = Node(start.val, [])
            copied[start] = clone
            for neighbor in start.neighbors:
                clone.neighbors.append(go(neighbor))
            return clone
        return go(node)

# runtime: 36.79%
# memory: 82.20%