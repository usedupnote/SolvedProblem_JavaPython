def solution(keyinput, board):
    answer = [0,0]
    
    order = {"up":[0,1], "down":[0,-1], "left":[-1,0], "right":[1,0]}
    
    for i in keyinput:
        curPos = []
        curPos.append(answer[0] + order[i][0])
        curPos.append(answer[1] + order[i][1])
        
        if -board[0]/2 <= curPos[0] < board[0]/2 and -board[1]/2 <= curPos[1] < board[1]/2 :
            answer = curPos
    
    return answer