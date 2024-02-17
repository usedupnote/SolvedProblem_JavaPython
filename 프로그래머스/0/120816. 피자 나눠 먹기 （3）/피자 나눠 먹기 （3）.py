def solution(slice, n):
    answer = n // slice
    answer += 0 if n % slice == 0 else 1
    return answer