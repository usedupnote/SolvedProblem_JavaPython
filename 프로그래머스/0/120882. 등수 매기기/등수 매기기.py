def solution(score):
    answer = []
    totalScore = []
    
    for i in score :
        totalScore.append(sum(i))
    totalScore.sort(reverse=True)
    
    for i in score :
        answer.append(totalScore.index(sum(i))+1)
    
    return answer