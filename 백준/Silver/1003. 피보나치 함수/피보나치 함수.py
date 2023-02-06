import sys
input = sys.stdin.readline

count = [[1, 0], [0, 1]]
result = []

T = int(input())

for i in range(T) :
    result.append(int(input()))

maximum = max(result)

for i in range(1, maximum) :
    count.append([count[i][0] + count[i-1][0], count[i][1] + count[i-1][1]])

for i in result :
    print(*count[i])