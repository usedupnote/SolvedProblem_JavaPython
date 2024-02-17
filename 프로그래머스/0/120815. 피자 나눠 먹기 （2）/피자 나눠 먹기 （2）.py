def solution(n):
    check = 6
    if n % 2 == 0 :
        n //= 2
        check //= 2
    if n % 3 == 0 :
        n //= 3
        check //= 3
    
    answer = n
    return answer