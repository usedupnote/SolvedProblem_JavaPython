import sys
input = sys.stdin.readline

T = int(input())

num = list(map(int, input().split()))

num.sort()

result = 0
compare = 1

for i in range(1, T) :
    if num[i - 1] != num[i] :
        result = max(result, compare)
        compare = 1
    else :
        compare += 1

result = max(result, compare)

print(result)