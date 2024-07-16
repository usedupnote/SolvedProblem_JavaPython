def solution(dots):
    answer = 0
    
    check = [True, False, False, False]
    
    def checkAngleRatio(dot):
        return (dot[0][0] - dot[1][0])/(dot[0][1] - dot[1][1])
    
    for i in range(1, 4) :
        check[i] = True
        dotA = [dots[0], dots[i]]
        dotB = []
        
        for j in range(1, 4) :
            if check[j] :
                continue
            dotB.append(dots[j])
            check[j] = True            
        
        if checkAngleRatio(dotA) == checkAngleRatio(dotB):
            answer = 1
            break
        
        check = [True, False, False, False]
        
    return answer