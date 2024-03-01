def solution(numbers, k):
    answer = numbers[(2 * (k-1)) % len(numbers)]
    return answer