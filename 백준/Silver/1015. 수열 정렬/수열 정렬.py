N = int(input())
A = list(map(int, input().split()))

result = [0] * N
checkNum = [[] for _ in range(1001)]

for i, num in enumerate(A):
    checkNum[num].append(i)

counter = 0

for i in checkNum:
    for j in i:
        result[j] = counter
        counter += 1

print(" ".join(map(str, result)))