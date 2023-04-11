import sys
input = sys.stdin.readline

N = int(input())
t1 = input()
t2 = input()

cnt = 0

for i in range(N) :
    if t1[i] != t2[i] : cnt += 1

print(cnt)