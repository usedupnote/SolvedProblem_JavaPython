import sys

N, L = map(int, sys.stdin.readline().strip().split())
froot = list(map(int, sys.stdin.readline().strip().split()))

froot.sort()

for i in froot :
    if L < i :
        break
    else :
        L += 1

print(L)