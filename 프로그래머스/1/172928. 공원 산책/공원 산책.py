def solution(park, routes):
    op = {"N":[-1,0], "S":[1,0], "W":[0,-1], "E":[0,1]}
    
    answer = [0,0]
    
    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j] == "S" :
                answer = [i, j]
                break
    
    for route in routes:
        routeItem = route.split(" ")

        dx,dy = answer
        for _ in range(int(routeItem[1])):
            dx += op[routeItem[0]][0]
            dy += op[routeItem[0]][1]
            
            if dx < 0 or dx >= len(park) or dy < 0 or dy >= len(park[0]) or park[dx][dy] == "X":
                dx,dy = answer
                break
        answer = [dx,dy]
    return answer