def solution(a, d, included):
    answer = 0
    length = len(included)
    for i in range(length) :
        if not included[i] :
            continue
        answer += a + (d * i)
    return answer