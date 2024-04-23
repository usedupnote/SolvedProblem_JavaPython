def solution(babbling):
    answer = 0
    canSpeak = ["aya", "ye", "woo", "ma"]
    
    for b in babbling:
        v = [0 for _ in range(4)]
        cnt = 0
        
        for i in canSpeak:
            if i in b:
                cnt += len(i)
                    
        if cnt == len(b):
            answer += 1
    
    return answer