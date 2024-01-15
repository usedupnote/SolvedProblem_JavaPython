def solution(order):
    answer = len(order) * 4500
    
    for s in order :
        if s.find("cafelatte") >= 0 :
            answer += 500 
        
    return answer