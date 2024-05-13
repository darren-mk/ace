# https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/

def solution(A, B, K):
    divisible = []
    i = A
    while A <= i <= B:
        if i % K == 0:
            divisible.append(i)
        i += 1
    return len(divisible)

solution(6, 11, 2)

# task score 50%
# correctness 100%
# performance 0%
