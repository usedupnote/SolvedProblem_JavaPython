def solution(arr, n):
    answer = []
    isOdd = len(arr) % 2
    for i, num in enumerate(arr) :
        if (i+isOdd) % 2 :
            answer.append(num + n)
        else :
            answer.append(num)
                
    return answer