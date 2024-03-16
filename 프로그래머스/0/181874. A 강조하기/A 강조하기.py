def solution(myString):
    answer = ''
    for i in myString:
        answer += 'A' if i=='a' or i=='A' else i.lower()
    return answer