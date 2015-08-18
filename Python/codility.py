def solution(K, A):
    # write your code in Python 2.7
    result = 0
    count_map = {}
    for element in A:
        if element in count_map:
            count_map[element] += 1
        else:
            count_map[element] = 1
    for element, count in count_map.items():
        if (K - element) in count_map:
            result += count*count_map[K - element]
    return result
    
def solution1(A):
    # write your code in Python 2.7
    P = 0
    Q = 0
    max_dist = 0
    for i in range(len(A)):
        max_new = A[i]*2
        max_P = A[i] + A[P] + i - P
        max_Q = A[i] + A[Q] + i - Q
        all_max = max(max_dist,max_new,max_P,max_Q)
        if all_max == max_dist:
            continue
        elif all_max == max_new:
            P = i
            Q = i
            max_dist = max_new
        elif all_max == max_P:
            Q = i
            max_dist = max_P
        elif all_max == max_Q:
            P = Q
            Q = i
            max_dist = max_Q
    return max_dist
def solution2(A):
    # write your code in Python 2.7
    P = 0
    Q = 0
    max_dist = 0
    for i in range(len(A)):
        max_new = A[i]*2
        max_P = A[i] + A[P] + i - P
        max_Q = A[i] + A[Q] + i - Q
        all_max = max(max_dist,max_new,max_P,max_Q)
        if all_max == max_dist:
            continue
        elif all_max == max_new:
            P = i
            Q = i
            max_dist = max_new
        elif all_max == max_P:
            Q = i
            max_dist = max_P
        elif all_max == max_Q:
            P = Q
            Q = i
            max_dist = max_Q
    return max_dist
