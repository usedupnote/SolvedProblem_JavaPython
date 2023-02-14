import sys

check = int(sys.stdin.readline())

num = list(map(int, sys.stdin.readline().split()))

print(num.count(check))