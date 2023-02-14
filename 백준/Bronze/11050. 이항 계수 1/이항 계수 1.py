def factorial(n) :
    facReturn = 1
    for i in range(2, n+1) :
        facReturn *= i
    return facReturn

N, M = map(int, input().split())
result = factorial(N) / (factorial(M) * factorial(N-M))

print(int(result))