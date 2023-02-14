import sys

A = list(map(int, input().split(":")))
B = list(map(int, input().split(":")))

resultTime = [0, 0, 0]

for i in range(3) :
    resultTime[i] += B[i] - A[i]

for i in range(2, 0, -1) :
    if resultTime[i] < 0 :
        resultTime[i] += 60
        resultTime[i-1] -= 1

if resultTime[0] < 0:
    resultTime[0] += 24

print("{0:02d}".format(resultTime[0]), end=":")
print("{0:02d}".format(resultTime[1]), end=":")
print("{0:02d}".format(resultTime[2]))