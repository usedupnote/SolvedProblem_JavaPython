def solution(n):
    dirX = [0, 1, 0, -1]
    dirY = [1, 0, -1, 0]
    
    answer = [[0 for _ in range(n)] for _ in range(n)]
    x, y, d = 0, 0, 0
    
    for i in range(n*n) :
        answer[x][y] = i+1
        
        if 0 <= x + dirX[d] < n and 0 <= y + dirY[d] < n :
            if answer[x + dirX[d]][y + dirY[d]] != 0:
                d = (d + 1) % 4
        else :
            d = (d + 1) % 4
        x += dirX[d]
        y += dirY[d]
    
    return answer