def solution(array):
    answer = [0, 0]
    for i in range(len(array)):
        if answer[0] < array[i] :
            answer = [array[i], i]
    return answer