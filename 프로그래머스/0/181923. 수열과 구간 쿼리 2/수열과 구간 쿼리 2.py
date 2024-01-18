def solution(arr, queries):
    answer = []
    
    for i in queries :
        result =  1_000_001
        
        for j in range(i[0], i[1]+1) :
            if arr[j] > i[2] and arr[j] < result :
                result = arr[j]
                
        if result == 1_000_001 :
            answer.append(-1)
        else :
            answer.append(result)
        
    return answer