def solution(arr):
    answer = 1
    for i in range(len(arr)):
        for j in range(len(arr)):
            if arr[i][j] != arr[j][i]:
                answer = 0
                return answer
    return answer