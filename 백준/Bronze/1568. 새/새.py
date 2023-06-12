import sys
input = sys.stdin.readline

N = int(input())
i = 1
cnt = 0
while N != 0 :
    if N - i < 0 :
        i = 1
        continue
    N-=i
    cnt+=1
    i+=1
print(cnt)