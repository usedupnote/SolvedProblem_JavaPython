import sys
input = sys.stdin.readline

N = int(input())

num = [0 for _ in range(N)]
result = [0 for _ in range(N + 4)]

for i in range(N) :
    if(i == 0) :
        num[0] = int(input())
        result[0] = num[0]
    elif(i == 1) :
        num[1] = int(input())
        result[1] = num[0] + num[1]
    elif(i == 2) :
        num[2] = int(input())
        result[2] = max(num[0] + num[2], num[1] + num[2], result[1])
    else :
        num[i] = int(input())
        result[i] = max(result[i-2] + num[i], result[i-3] + num[i-1] + num[i], result[i-1])

print(result[N-1])