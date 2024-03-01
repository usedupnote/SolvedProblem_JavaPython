def solution(routes):
    answer = 0
    routes.sort(key=lambda x: x[1])
    last = -30001
    for i in routes :
        if i[0] > last :        
            last = i[1]
            answer += 1
    return answer