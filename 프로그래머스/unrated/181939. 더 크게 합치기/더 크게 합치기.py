def solution(a, b):
    lenA = len(str(a)) 
    lenB = len(str(b)) 
    
    answer = ((10**lenA) * b) + a
    print(answer, ((10**lenB) * a) + b)
    answer = max(answer, ((10**lenB) * a) + b)
    return answer