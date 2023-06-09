import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num = [0 for _ in range(N+1)]

for i in range(M) :
    A, B = map(int, input().split())
    num[A] += 1
    num[B] += 1

for i in range(N) :
    print(num[i+1])