def solution(n, lost, reserve):
    answer = n - len(lost)
    pos = 0
    
    for i in range(len(lost)) :
        for j in range(len(reserve)) :
            if (lost[i] == reserve[j]) :
                lost[i] = -13
                reserve[j] = -11
                answer += 1
                break
                
    lost.sort()
    reserve.sort()
    
    for i in lost :
        if i >= 0 :
            for j in range(pos, len(reserve)) :
                if i > reserve[j] + 1 :
                    pos += 1
                elif reserve[j] == i + 1 or reserve[j] == i - 1 :
                    answer += 1
                    pos += 1
                    break
                else :
                    break
    return answer