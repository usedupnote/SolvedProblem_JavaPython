def solution(polynomial):
    answer = ''
    x, num = 0, 0
    
    for i in polynomial.split(" + "):
        if i[-1] == "x" :
            if i == "x" :
                x += 1
            else :
                x += int(i[:-1])
        else :
            num += int(i)
    
    if x == 1 :
        answer += "x"
    elif x > 1 :
        answer += str(x) + "x"

    if x != 0 and num != 0:
        answer += " + "
    
    if num > 0 :
        answer += str(num)
    
    return answer