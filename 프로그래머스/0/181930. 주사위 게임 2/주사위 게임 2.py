def solution(a, b, c):
    answer = a+b+c
    num = {a, b, c}
    
    if len(num) < 3 :
        answer *= a**2+b**2+c**2
    if len(num) < 2 :
        answer *= a**3+b**3+c**3
        
    return answer