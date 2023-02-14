import sys
input = sys.stdin.readline

num = list(map(int, input().split()))

result = abs((num[3] + num[0]) - (num[2] + num[1]))

print(result)
