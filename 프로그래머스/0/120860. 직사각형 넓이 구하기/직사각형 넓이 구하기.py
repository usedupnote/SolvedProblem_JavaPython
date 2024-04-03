def solution(dots):
    answer = 0
    v1, v2 = [0, 0]
    
    for i in dots:
        v1 += i[0]
        v2 += i[1]
    
    answer = abs((v1 - (dots[0][0] * 4)) / 2 * (v2 - (dots[0][1] * 4)) / 2)
        
    return answer