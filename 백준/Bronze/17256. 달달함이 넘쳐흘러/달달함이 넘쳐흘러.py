import sys

numA = list(map(int, sys.stdin.readline().split()))
numC = list(map(int, sys.stdin.readline().split()))

print(numC[0] - numA[2], numC[1] // numA[1], numC[2] - numA[0])