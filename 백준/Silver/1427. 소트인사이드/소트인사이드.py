import sys
input = sys.stdin.readline

num = list(map(int, input().strip()))

num.sort(reverse = True)

print(*num, sep = "")