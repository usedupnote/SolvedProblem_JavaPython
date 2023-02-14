import sys
input = sys.stdin.readline

N = int(input())

result = 0
num = [[1,1,1,1,1,1,1,1,1,1]]

for i in range(N):
    num.append([sum(num[i][j:9]) for j in range(9)])
    result = (result + sum(num[i])) % 10007
print(result)