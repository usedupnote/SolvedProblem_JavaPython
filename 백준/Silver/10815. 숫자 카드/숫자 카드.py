N = int(input())
numN = set(list(map(int, input().split())))
M = int(input())
numM = list(map(int, input().split()))

result = []

for i in numM:
    if i in numN:
        result.append(1)
    else:
        result.append(0)

print(*result)