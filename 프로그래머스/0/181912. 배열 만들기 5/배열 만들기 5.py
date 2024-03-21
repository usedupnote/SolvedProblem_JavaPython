def solution(intStrs, k, s, l):
    answer = []
    for i in intStrs:
        if k < int(i[s:s+l]):
            answer.append(int(i[s:s+l]))
    return answer