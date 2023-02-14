N = list(map(int, input().split()))
result = 1

left = N[0] // N[1]
share = N[0] % N[1]


for i in range(N[1]) :
    if share <= i :
        result *= left
    else :
        result *= (left + 1)
print(result)