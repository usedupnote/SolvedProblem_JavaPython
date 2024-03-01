def solution(hp):
    answer = hp//5 + ((hp%5)//3) + (hp%5)%3
    return answer