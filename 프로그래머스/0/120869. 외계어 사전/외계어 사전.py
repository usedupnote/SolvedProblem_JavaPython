def solution(spell, dic):
    answer = 1
    
    for word in dic:
        answer = 1
        
        for i in spell:
            if word.count(i) == 1 :
                continue
            answer = 2
        
        if answer == 1:
            break
        
    return answer