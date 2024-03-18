def solution(my_strings, parts):
    answer = ''
    for i, st in enumerate(my_strings):
        answer += st[parts[i][0]:parts[i][1]+1]
    return answer