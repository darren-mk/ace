# https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/

def solution(A):

    pos = []
    neg = []

    for n in A:
        if 0 < n: pos.append(n)
        if n < 0: neg.append(n)

    pos.sort()
    pos.reverse()
    neg.sort()

    if len(neg) in [0, 1]:
        return pos[0] * pos[1] * pos[2]

    if 1 < len(neg) and 0 < len(pos):
        if pos[1] * pos[2] < neg[0] * neg[1]:
            return pos[0] * neg[0] * neg[1]
        else:
            return pos[0] * pos[1] * pos[2]

    if len(pos) == 0:
        neg.reverse()
        return neg[0] * neg[1] * neg[2]

solution([-3, 1, 2, -2, 5, 6])
solution([-10, -2, -4])
solution([-5, -5, -5, 4])
