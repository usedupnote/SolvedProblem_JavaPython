def solution(a, b):
    answer = 0
    check = (a % 2) + (b % 2)
    
    if check == 2 :
        answer = a * a + b * b
    elif check == 1 :
        answer = 2 * (a + b)
    else :
        answer = abs(a - b)
        
    return answer