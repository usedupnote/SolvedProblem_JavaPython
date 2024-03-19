def solution(myString):
    answer = ''
    for i in myString:
        answer += "l" if ord(i) <= ord("l") else i
    return answer