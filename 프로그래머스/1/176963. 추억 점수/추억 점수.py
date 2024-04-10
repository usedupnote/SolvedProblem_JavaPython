def solution(name, yearning, photo):
    point = {}
    answer = []
    
    for i, text in enumerate(name):
        point[text] = yearning[i]
        
    for persons in photo:
        answer.append(0)
        for person in persons:
            if person in point:
                answer[-1] += point[person]
                
    return answer