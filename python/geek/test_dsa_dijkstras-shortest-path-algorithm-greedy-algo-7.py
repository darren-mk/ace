# https://www.geeksforgeeks.org/dsa/dijkstras-shortest-path-algorithm-greedy-algo-7/

import sys
import heapq

def dijkstra(adj, src):
    V = len(adj)
    distances = [sys.maxsize] * V
    pq = []
    distances[src] = 0
    heapq.heappush(pq, (0, src))
    while pq:
        parent_distance, parent_node = heapq.heappop(pq)
        if distances[parent_node] < parent_distance: continue
        for neighbor, weight in adj[parent_node]:
            if parent_distance + weight < distances[neighbor]:
                distances[neighbor] = parent_distance + weight
                heapq.heappush(pq, (distances[neighbor], neighbor))
    return distances

def test():
    # basic heap sanity test
    a = []
    heapq.heappush(a, (0,1))
    heapq.heappush(a, (2,3))
    assert heapq.heappop(a) == (0,1)
    assert heapq.heappop(a) == (2,3)

    # original example
    src = 0
    adj = [
        [(1, 4), (2, 8)],
        [(0, 4), (4, 6), (2, 3)],
        [(0, 8), (3, 2), (1, 3)],
        [(2, 2), (4, 10)],
        [(1, 6), (3, 10)]
    ]
    assert dijkstra(adj, src) == [0, 4, 7, 9, 10]

    # 1) single-node graph
    adj = [[]]
    assert dijkstra(adj, 0) == [0]

    # 2) source is not 0
    adj = [
        [(1, 2)],
        [(0, 2), (2, 5)],
        [(1, 5)]
    ]
    # from src=1: distances to nodes 0 and 2
    assert dijkstra(adj, 1) == [2, 0, 5]

    # 3) graph with unreachable nodes
    adj = [
        [(1, 3)],   # 0 -> 1
        [(0, 3)],   # 1 -> 0
        []          # 2 is isolated
    ]
    inf = sys.maxsize
    assert dijkstra(adj, 0) == [0, 3, inf]

    # 4) multiple equal shortest paths
    # 0 → 1 → 3 = 4
    # 0 → 2 → 3 = 4
    adj = [
        [(1, 2), (2, 2)],
        [(0, 2), (3, 2)],
        [(0, 2), (3, 2)],
        [(1, 2), (2, 2)]
    ]
    assert dijkstra(adj, 0) == [0, 2, 2, 4]
