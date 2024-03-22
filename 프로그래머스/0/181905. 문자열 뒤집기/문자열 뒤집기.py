def solution(my_string, s, e):
    answer = list(my_string)
    answer[s:e+1]=answer[s:e+1][::-1]
    return ''.join(answer)