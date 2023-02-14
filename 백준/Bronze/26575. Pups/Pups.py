import sys
input = sys.stdin.readline

T = int(input())

result = []

for i in range(T):
    num = list(map(float, input().split()))

    result.append("$" + format(num[0] * num[1] * num[2], ".2f"))

print(*result, sep="\n")