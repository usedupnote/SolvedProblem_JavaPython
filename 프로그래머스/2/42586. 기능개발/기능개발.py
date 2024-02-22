def solution(progresses, speeds):
    answer = []
    pos, count = 1, 1
    pLen = len(progresses)
    
    time = ((100 - progresses[0]) // speeds[0]) + (0 if (100 - progresses[0]) % speeds[0] == 0 else 1)
    
    while pos < pLen :
        cur = progresses[pos] + (speeds[pos] * time)
        if cur < 100 :
            answer.append(count)
            time = ((100 - progresses[pos]) // speeds[pos]) + (0 if (100 - progresses[pos]) % speeds[pos] == 0 else 1)
            count = 1
        else :
            count += 1
        pos+=1
    
    answer.append(count)
    return answer