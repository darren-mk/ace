# https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/

def solution(A):
    spi = 1
    A.sort()
    for n in A:
        if spi == n:
            spi = n + 1
    return spi

solution([1,3,6,4,1,2])
