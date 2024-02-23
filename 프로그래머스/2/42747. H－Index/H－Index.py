def solution(citations):
    answer = -1
    lenC = len(citations)
    citations.sort()

    maxC = 0
    for i in citations:
        if maxC < i:
            maxC = i
            
    count = [0 for _ in range(maxC+1)]
            
    for i in citations:
        count[i] += 1
    
    cnt = 0
    
    while lenC-cnt > answer :
        answer += 1
        cnt += count[answer]
    return answer