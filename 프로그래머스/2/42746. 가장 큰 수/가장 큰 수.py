def solution(numbers):
    answer = ''
    nLen = len(numbers)
    strNumber = list(map(str, numbers))
    for i in range(nLen):
        strNumber[i] *= 3 
    strNumber.sort(reverse=True)
    if strNumber[0] == "000" :
        answer="0"
    else :
        for i in strNumber:
            answer+=i[:len(i)//3]
    return answer