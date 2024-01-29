import sys
input = sys.stdin.readline

result = 0

N, M, K = map(int, input().split());

ButtonList1 = list(map(int, input().split()))
ButtonList2 = list(map(int, input().split()))

compare = [[0]*M for _ in range(N)]

for i in range(N) :
    for j in range(M) :
        if ButtonList1[i] != ButtonList2[j] :
            continue

        if i == 0 or j == 0:
            compare[i][j] = 1
        else :
            compare[i][j] = compare[i-1][j-1] + 1

        result = max(result, compare[i][j])

print(result)