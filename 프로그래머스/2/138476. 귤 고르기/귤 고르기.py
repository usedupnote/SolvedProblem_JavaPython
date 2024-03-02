def solution(k, tangerine):
    answer = len(tangerine)
    maxT = max(tangerine)
    minT = min(tangerine)
    listT = [0 for _ in range(maxT - minT + 1)]
    
    for i in tangerine:
        listT[i-minT] += 1
        
    listT.sort(reverse = True)

    for i, num in enumerate(listT):
        k -= num
        if k <= 0 :
            answer = i+1
            break
    
    return answer