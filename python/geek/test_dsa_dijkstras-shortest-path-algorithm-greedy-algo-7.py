# https://www.geeksforgeeks.org/dsa/dijkstras-shortest-path-algorithm-greedy-algo-7/

import sys
import heapq

def dijkstra(adj, src):
    V = len(adj)
    pq = []
    distances = [sys.maxsize] * V
    distances[src] = 0
    heapq.heappush(pq, (0, src))
    while pq:
        node_dist, node = heapq.heappop(pq)
        if node_dist > distances[node]: continue
        for neighbor, weight in adj[node]:
            new_dist = distances[node] + weight
            if new_dist < distances[neighbor]:
                distances[neighbor] = new_dist
                heapq.heappush(pq, (new_dist, neighbor))
    return distances

def test():
    a = []
    heapq.heappush(a, (0,1))
    heapq.heappush(a, (2,3))
    assert heapq.heappop(a) == (0,1)
    assert heapq.heappop(a) == (2,3)
    src = 0
    adj = [
        [(1, 4), (2, 8)],
        [(0, 4), (4, 6), (2, 3)],
        [(0, 8), (3, 2), (1, 3)],
        [(2, 2), (4, 10)],
        [(1, 6), (3, 10)]]
    assert dijkstra(adj, src) == [0, 4, 7, 9, 10]