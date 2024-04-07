def solution(arr):
    answer = arr.copy()
    x = 1
    
    while True:
        if len(arr) <= x:
            for i in range(len(arr), x) :
                answer.append(0)
            break

        x *= 2
            
    return answer