import math
def solution(balls, share):
    return math.factorial(balls) // (math.factorial(share) * math.factorial(balls - share))