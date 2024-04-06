def solution(arr, flag):
    answer = []
    for i, num in enumerate(arr):
        if not flag[i] :
            for _ in range(num):
                answer.pop()
            continue
        for _ in range(num * 2):
            answer.append(num)
    return answer