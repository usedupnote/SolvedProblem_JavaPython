def solution(arr, query):
    answer = []
    start = 0
    end = len(arr) - 1
    for i, num in enumerate(query):
        if i % 2 == 0:
            end = min(end, start + num)
        else :
            start += num
    answer = arr[start:end+1]
    return answer