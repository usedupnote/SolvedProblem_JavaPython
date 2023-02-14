import sys

A = int(sys.stdin.readline())
B = int(sys.stdin.readline())
C = int(sys.stdin.readline())

countNum = []

for i in range(10) :
    countNum.append(0)

num = list(str(A*B*C))

for i in num :
    countNum[int(i)] += 1

for i in range(10) :
    countNum[i] = str(countNum[i])

print("\n".join(countNum))