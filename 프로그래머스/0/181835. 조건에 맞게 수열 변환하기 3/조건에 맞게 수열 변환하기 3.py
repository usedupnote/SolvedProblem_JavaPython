def solution(arr, k):
    if k % 2 != 0 :
        return [i * k for i in arr]
    else :
        return [i + k for i in arr]
