def solution(want, number, discount):
    answer = 0
    point = 10
    wantList = {}
    
    for i, w in enumerate(want):
        wantList[w] = number[i]
        
    for end, d in enumerate(discount):
        if d in wantList :
            wantList[d] -= 1
            if wantList[d] >= 0 :
                point -= 1
                
        if end < 9 :
            continue
            
        if end != 9 and discount[end - 10] in wantList :
            wantList[discount[end - 10]] += 1
            if wantList[discount[end - 10]] > 0 :
                point += 1
        
        if point == 0:
            answer+=1
        
    return answer