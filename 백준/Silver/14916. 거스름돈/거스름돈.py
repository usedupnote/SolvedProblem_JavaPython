import sys
N = int(sys.stdin.readline())    

result = 0

while N % 5 != 0 :
    if(N < 0) :
        break
    result += 1
    N -= 2

result += N // 5

if N % 5 == 0 :
    print(result)
else :
    print(-1)