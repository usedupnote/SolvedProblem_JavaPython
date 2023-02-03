import sys
T = int(sys.stdin.readline().strip())

num = [0] * (T + 1)

for i in range(2, T+1) :
    num[i] = num[i-1] + 1

    if i % 3 == 0 : num[i] = min(num[i//3] + 1, num[i])
    if i % 2 == 0 : num[i] = min(num[i//2] + 1, num[i])

print(num[T])