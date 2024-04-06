def solution(myString):
    answer = myString.split("x")
    answer.sort()
    while len(answer) != 0:
        if answer[0] == "":
            answer.pop(0)
        else:
            break
    return answer