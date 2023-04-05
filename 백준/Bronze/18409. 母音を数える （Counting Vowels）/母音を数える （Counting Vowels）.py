import sys
input = sys.stdin.readline

check = ['a','e','i','o','u']

N = int(input())
S = list(input())

cnt = 0

for i in check :
    cnt += S.count(i)

print(cnt)