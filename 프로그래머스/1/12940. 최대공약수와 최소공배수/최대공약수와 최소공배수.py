def solution(n, m):
    gcd = 0
    
    for i in range(min(n,m), 0, -1):
        if n % i == 0 and m % i == 0:
            gcd = i
            return [gcd, (n*m)//gcd]