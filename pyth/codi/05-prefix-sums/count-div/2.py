# https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/

def solution(A, B, K):
    if A == B:
        if A % K == 0: return 1
        else: return 0
    else:
        if B % K == 0:
            return (B - A + 2) // K
        else:
            return (B - A + 1) // K

solution(6, 11, 2)
solution(0, 14, 2)
