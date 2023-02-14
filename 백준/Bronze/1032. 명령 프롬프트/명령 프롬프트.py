import sys
input = sys.stdin.readline
N = int(input())

check = list(input().strip())

check_len = len(check)

for i in range(1, N):
    compare = list(input().strip())
    for j in range(check_len) :
        if check[j] != compare[j]:
            check[j] = "?"

print(*check, sep="")