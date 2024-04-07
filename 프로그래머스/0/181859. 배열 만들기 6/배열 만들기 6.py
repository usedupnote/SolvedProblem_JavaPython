def solution(arr):
    answer = []
    i = 0
    while True:
        if i >= len(arr):
            break
        
        if len(answer) == 0:
            answer.append(arr[i])
            i += 1
            continue
        
        if answer[-1] == arr[i]:
            answer.pop()
        else :
            answer.append(arr[i])
            
        i+=1
    if len(answer) == 0:
        answer.append(-1)
    return answer