def solution(arr):
    answer = 0
    while True:
        checkArr = arr.copy()
        for i, num in enumerate(checkArr):
            
            if num >= 50 and num % 2 == 0 :
                checkArr[i] //= 2
            elif num < 50 and num % 2 == 1 :
                checkArr[i] = (checkArr[i] * 2) + 1
                
        if checkArr == arr:
            break
            
        answer += 1
        arr = checkArr.copy()
    return answer