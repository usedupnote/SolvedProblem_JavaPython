def solution(a, b):
    answer = 2 * a * b
    answer = max(answer, (a * (10 ** len(str(b)))) + b)
    return answer