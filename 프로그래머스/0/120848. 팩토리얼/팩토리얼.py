import math

def solution(n):
    answer = 0
    while n >= math.factorial(answer+1):
        answer += 1
    return answer