def solution(array):
    count = [0 for _ in range(1000)]
    answer = 0
    
    maxCount = 0
    
    for i in array :
        count[i] += 1
        
        if maxCount < count[i] :
            maxCount = count[i]

    for i in range(1000) :
        if count[i] == maxCount :
            if answer != 0 :
                answer = -1
                break
            
            answer = i
    
    return answer