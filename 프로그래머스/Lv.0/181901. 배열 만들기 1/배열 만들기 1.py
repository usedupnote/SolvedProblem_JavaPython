def solution(n, k):
    answer = []
    i = 1
    while True :
        if k * i > n :
            break
        answer.append(k * i)
        i += 1
        
    return answer