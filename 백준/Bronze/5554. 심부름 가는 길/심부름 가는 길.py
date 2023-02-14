import sys
input = sys.stdin.readline

result = 0

for i in range(4):
    result += int(input())

print(result//60, result%60, sep="\n")