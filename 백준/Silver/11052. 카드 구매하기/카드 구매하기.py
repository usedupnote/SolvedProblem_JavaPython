import sys
input = sys.stdin.readline

N = int(input())

num = list(map(int, input().split()))

for i in range(N) :
    for j in range(i) :
        if i - j == 0 :
            break
        num[i] = max(num[i], num[j] + num[i - j - 1])
print(num[i])