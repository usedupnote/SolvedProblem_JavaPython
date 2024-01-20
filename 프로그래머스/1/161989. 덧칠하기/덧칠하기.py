def solution(n, m, section):
    answer = 0
    check = section[0] - 1
    for i in section :
        if check < i :
            check = i+m-1
            answer += 1
    return answer