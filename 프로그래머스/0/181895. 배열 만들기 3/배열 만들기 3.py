def solution(arr, intervals):
    answer = []
    for i in intervals:
        answer += arr[i[0]:i[1]+1]
    return answer