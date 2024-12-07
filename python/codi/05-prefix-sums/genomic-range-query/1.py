# https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/

def solution(S, P, Q):

    vals = {'A': 1,
            'C': 2,
            'G': 3,
            'T': 4}

    result = []
    
    for i in range(len(P)):
        if P[i] == Q[i]:
            result.append(vals[S[P[i]]])
        else: 
            minimum = 5
            for n in S[P[i]:Q[i]+1]:
                minimum = min(minimum, vals[n])
            result.append(minimum)

    return result
            
solution('CAGCCTA', [2,5,0], [4,5,6])

# task 62%
# correntness 100%
# performance 0%
