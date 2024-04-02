def solution(arr, queries):
    answer = arr.copy()
    
    for i in queries:
        for j in range(i[0], i[1]+1):
                answer[j] += 1
                
    return answer