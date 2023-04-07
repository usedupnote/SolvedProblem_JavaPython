N = int(input())
num = [[0 for _ in range(10)] for _ in range(N)]

for i in range(1, 10) :
    num[0][i] = 1

for i in range(1, N) :
    for j in range(10) :
        if j != 9 : num[i][j] += num[i - 1][j + 1]
        if j != 0 : num[i][j] += num[i - 1][j - 1]
            
print(sum(num[N-1]) % 1000000000)