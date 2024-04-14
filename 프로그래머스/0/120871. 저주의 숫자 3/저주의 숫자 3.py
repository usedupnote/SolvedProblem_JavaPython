def solution(n):
    answer = 1
    for i in range(2, n+1):
        while True:
            answer += 1
            if answer % 3 == 0 :
                continue
            if "3" in str(answer) :
                continue
            break
    return answer