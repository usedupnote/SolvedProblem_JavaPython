import sys
input = sys.stdin.readline

N = int(input())
num = [0 for _ in range(N+6)]
for i in range(N) :
    d,s = map(int, input().split())

    num[i+d] = max(num[i+d], num[i] + s)
    for j in range(i+d+1, N+1) :
        num[j] = max(num[j-1], num[j])

print(num[N])