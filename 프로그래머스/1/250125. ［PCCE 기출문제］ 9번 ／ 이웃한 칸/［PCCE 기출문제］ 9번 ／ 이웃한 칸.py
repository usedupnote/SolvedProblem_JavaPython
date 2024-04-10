def solution(board, h, w):
    dirX = [0,-1,0,1]
    dirY = [-1,0,1,0]
    
    answer = 0
    n = len(board)
    m = len(board[0])
    
    for d in range(4) :
        dx = h + dirX[d]
        dy = w + dirY[d]
        
        if 0 <= dx < n and 0<= dy < m:
            if board[h][w] == board[dx][dy]:
                answer += 1
    
    return answer