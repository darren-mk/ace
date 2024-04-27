# https://app.codility.com/programmers/lessons/1-iterations/binary_gap/

def Solution(N):
    b = bin(N)
    count_on = False 
    current_gap = 0 
    max_gap = 0
    for c in b:
        if (c == '1') and (count_on == False):
            count_on = True
        elif (c == '1') and (count_on == True):
            if max_gap < current_gap:
                max_gap = current_gap
            current_gap = 0 
        else:
            if count_on == True:
                if c == '0':
                    current_gap = current_gap + 1
    return max_gap



