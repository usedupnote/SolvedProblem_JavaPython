def solution(board):
    answer = 0
    posX = [1,1,1,0,-1,-1,-1,0]
    posY = [-1,0,1,1,1,0,-1,-1]
    n = len(board)
    
    for h in range(n):
        for v in range(n):
            if board[h][v] == 1:
                continue
            cnt = 0
            
            for i in range(8):
                x = h + posX[i]
                y = v + posY[i]
                
                if 0<=x<n and 0<=y<n and board[x][y] == 1:
                        cnt+=1
                        break
                
            if cnt == 0:
                answer += 1
                
    return answer