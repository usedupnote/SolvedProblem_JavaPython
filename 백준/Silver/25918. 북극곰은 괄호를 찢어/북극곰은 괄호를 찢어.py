import sys
input = sys.stdin.readline

N = int(input())
S = list(input().strip())

result = 0

maximum = 0
checkMax = []

if N % 2 == 0 :
    for i in range(N):
        len_checkMax = len(checkMax)

        if len_checkMax == 0 or checkMax[len_checkMax - 1] == S[i] :
            checkMax.append(S[i])
        else :
            maximum = max(maximum, len_checkMax)
            checkMax.pop()

    if len(checkMax) == 0:
        print(maximum)
    else :
        print(-1)
else :
    print(-1)