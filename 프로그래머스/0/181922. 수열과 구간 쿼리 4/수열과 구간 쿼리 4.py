def solution(arr, queries):
    answer = arr
    
    for i, num in enumerate(queries):
        for j in range(num[0], num[1]+1) :
            if j == 0:
                answer[j] += 1
            elif j % num[2] == 0:
                answer[j] += 1
        
    return answer