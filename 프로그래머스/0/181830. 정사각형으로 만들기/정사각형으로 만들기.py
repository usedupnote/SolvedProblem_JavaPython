def solution(arr):
    answer = arr.copy()
    dif = len(arr) - len(arr[0])
    if dif < 0 :
        for _ in range(-dif):
            answer.append([0 for _ in range(len(arr[0]))])
    else :
        for i in range(len(arr)):
            [answer[i].append(0) for _ in range(dif)]
            
    return answer