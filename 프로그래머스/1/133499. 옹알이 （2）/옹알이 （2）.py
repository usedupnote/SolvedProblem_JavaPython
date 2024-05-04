def solution(babbling):
    answer = 0
    
    for babble in babbling:
        pronunciation = {"aya":True, "ye":True, "woo":True, "ma":True}
        pos = 0
        check = False
        
        while pos < len(babble) :
            check = False
            for i in pronunciation :
                if not pronunciation[i] :
                    pronunciation[i] = True
                    continue
                
                if not check and babble[pos:].find(i) == 0 :
                    pronunciation[i] = False
                    check = True
                    pos += len(i)
                    
            if not check :
                break
        
        if check:
            answer += 1

    return answer