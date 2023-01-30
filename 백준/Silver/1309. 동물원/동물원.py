import sys
input = sys.stdin.readline

N = int(input())

num = [[1, 1, 1]]

for i in range(N - 1):
    num.append([sum(num[i]) % 9901, (num[i][0] + num[i][2]) % 9901, (num[i][0] + num[i][1]) % 9901])

print(sum(num[N - 1]) % 9901)