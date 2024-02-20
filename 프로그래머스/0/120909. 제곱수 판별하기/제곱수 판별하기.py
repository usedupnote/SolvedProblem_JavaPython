def solution(n):
    answer = 1
    count = 1
    
    while count**2 <= n :
        if n == count**2:
            return answer
        count += 1
    answer = 2
    return answer
