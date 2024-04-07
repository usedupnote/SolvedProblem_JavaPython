def solution(strArr):
    answer = 0
    lenStr = [0 for _ in range(31)]
    
    for i in strArr:
        lenStr[len(i)] += 1
        
    for i in lenStr:
        if answer < i:
            answer = i
            
    return answer