def solution(my_string, m, c):
    answer = ''
    cur = 0
    while cur < len(my_string):
        answer += my_string[cur:cur+m][c-1]
        cur += m
    return answer