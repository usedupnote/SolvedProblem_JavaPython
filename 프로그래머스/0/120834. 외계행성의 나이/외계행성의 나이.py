def solution(age):
    answer = ''
    length = len(str(age))
    for i in range(length):
        answer += chr(ord("a") + int(str(age)[i]))
    return answer