# https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/

def solution(A):
    A.sort()
    pick = 1
    for n in A:
        if pick != n:
            return 0
        else:
            pick += 1
    return 1
            
