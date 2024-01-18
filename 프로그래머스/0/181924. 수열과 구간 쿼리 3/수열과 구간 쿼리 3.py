def solution(arr, queries):
    answer = arr
    
    for i in queries :
        answer[i[0]] += answer[i[1]]
        answer[i[1]] = answer[i[0]] - answer[i[1]]
        answer[i[0]] -= answer[i[1]]
    return answer