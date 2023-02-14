import sys
input = sys.stdin.readline

T = int(input())
num = list(map(int, input().split()))

compare = num[0]
maximum = 0

for i in range(1, T) :
    if num[i-1] >= num[i] :
        maximum = max(num[i-1] - compare, maximum)
        compare = num[i]

maximum = max(num[len(num)-1] - compare, maximum)

print(maximum)