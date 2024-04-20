def solution(a, b):
    answer = 2
    n = 2
    while(a >= n) :
        if (a % n) + (b % n) == 0:
            a //= n
            b //= n
            continue
        n += 1
    
    n = 2
    while(n <= 5) :
        if b!=0 and b%n==0:
            b //= n
            continue
        n += 3
    print(a,b)
    if b == 1:
        answer = 1
        
    return answer