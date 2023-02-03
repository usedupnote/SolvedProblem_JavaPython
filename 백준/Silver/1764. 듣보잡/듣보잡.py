import sys
input = sys.stdin.readline

N, M = map(int, input().split())

listN = [input().strip() for _ in range(N)]
listM = [input().strip() for _ in range(M)]

result = list(set(listN) & set(listM))

result.sort()

print(len(result), *result, sep="\n")