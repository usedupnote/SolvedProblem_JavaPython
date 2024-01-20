def solution(k, m, score):
    answer = 0
    
    s = [0] * (k + 1)
    
    for i in score :
        s[i] += 1
    
    for i in range(k, 0, -1) :
        answer += i * (s[i] // m) * m
        s[i-1] += s[i] % m
    
    return answer