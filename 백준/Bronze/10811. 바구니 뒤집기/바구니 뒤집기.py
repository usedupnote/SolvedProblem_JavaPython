import sys
input = sys.stdin.readline

N,M = map(int, input().split())

num = [i for i in range(N+1)]

for i in range(M) :
    a,b = map(int, input().split())
    while a<b :
        num[a] += num[b]
        num[b] = num[a] - num[b]
        num[a] -= num[b]
        a+=1
        b-=1

for i in range(1, N+1) :
    print(num[i],end=" ")