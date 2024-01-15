def solution(n, control):
    answer = n
    
    check = {"w" : 1, "s" : -1, "d" : 10, "a" : -10}
    length = len(control)
    
    for i in range(length) :
        answer += check.get(control[i])
    
    return answer