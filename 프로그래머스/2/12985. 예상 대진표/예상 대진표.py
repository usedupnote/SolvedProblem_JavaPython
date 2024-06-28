def solution(n,a,b):
    answer = 0
    a -= 1
    b -= 1
    
    while a != b:
        answer += 1
        a //= 2
        b //= 2
        
    return answer