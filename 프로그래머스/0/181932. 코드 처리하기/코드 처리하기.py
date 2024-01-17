def solution(code):
    answer = ''
    check = 0
    length = len(code)
    for i in range(length) :
        if code[i] == "1" :
            check = (check + 1) % 2
        else :
            if (i + check) % 2 == 0 :
                answer += code[i]
    
    if answer == "" :
        answer = "EMPTY"
        
    return answer