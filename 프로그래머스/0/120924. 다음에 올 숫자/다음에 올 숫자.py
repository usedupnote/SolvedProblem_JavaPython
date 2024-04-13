def solution(common):
    answer = 0
    
    if (len(common) == 2):
        answer = (2 * common[1]) - common[0]
        return answer
    
    n1 = common[-3:][2] - common[-3:][1]
    n2 = common[-3:][1] - common[-3:][0]
    
    if (n1 == n2) :
        answer = common[-1] + n1 
    else :
        answer = common[-1] * (n1/n2)
    return answer