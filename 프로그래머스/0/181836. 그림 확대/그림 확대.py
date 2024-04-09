def solution(picture, k):
    answer = [[] for _ in range(len(picture) * k)]
    
    for i, values in enumerate(picture):
        for j, value in enumerate(values):
            for m in range((i*k), (i*k)+k):
                answer[m] += value * k
    
    for i in range(len(picture) * k) :
        answer[i] = "".join(answer[i])
    
    return answer