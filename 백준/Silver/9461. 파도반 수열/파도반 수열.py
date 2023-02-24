import sys
input = sys.stdin.readline

N = int(input())

maximum = 0
num = [0 for _ in range(N)]

for i in range(N) :
    num[i] = int(input())
    maximum = max(num[i], maximum+1)

result = [1, 1, 1, 2, 2]

for i in range(5, maximum+1) :
    result.append(result[i - 1] + result[i - 5])


for i in range(N) :
    print(result[num[i]-1])