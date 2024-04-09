def solution(board, k):
    answer = 0
    for i in range(min(len(board), k+1)):
        for j in range(min(len(board[0]), k-i+1)):
            answer += board[i][j]
    return answer