def solution(t, p):
    answer = 0
    
    for i in range(len(t)-len(p)+1):
        if int(t[i:i+len(p)]) <= int(p):
            answer += 1
            
    return answer