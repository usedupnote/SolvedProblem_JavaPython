def solution(numLog):
    answer = ''
    
    number = 0
    for i in numLog :
        compare = i - number
        
        if compare == 1:
            answer += "w"
        elif compare == -1:
            answer += "s"
        elif compare == 10:
            answer += "d"
        elif compare == -10:
            answer += "a"
            
        number = i
            
    return answer