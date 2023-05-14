import sys
input = sys.stdin.readline

N = int(input())

cnt = 1
func = lambda x:"odd" if (x%2==1) else "even"

while N != 0 :
    print(cnt, ". ", func(N), " ", N//2, sep="")
    N = int(input())
    cnt += 1