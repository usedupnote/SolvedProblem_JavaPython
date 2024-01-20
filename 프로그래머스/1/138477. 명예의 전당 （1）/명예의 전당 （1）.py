def solution(k, score):
    answer = []
    stage = []
    
    for i in range(len(score)) :
        stage.append(score[i])
        stage.sort()
        if i >= k :
            stage.pop(0)
        answer.append(stage[0])
        
    return answer