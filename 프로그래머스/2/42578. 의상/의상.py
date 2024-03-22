def solution(clothes):
    answer = 1
    counter = {}
    
    for i in clothes:
        if counter.get(i[1]):
            counter[i[1]] += 1
        else :
            counter[i[1]] = 2
            
    for i in counter:
        answer *= counter[i]
    answer -= 1
    
    return answer