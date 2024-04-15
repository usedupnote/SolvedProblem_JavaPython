def solution(num, total):
    answer = []
    n = (total // num) - (num // 2) + (0 if (num % 2 == 1) else 1)
    
    for i in range(num) :
        answer.append(n+i)
        
    return answer