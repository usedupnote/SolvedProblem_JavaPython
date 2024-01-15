def solution(number, n, m):
    answer = 0
    if number % n + number % m == 0 :
        answer = 1
        
    return answer