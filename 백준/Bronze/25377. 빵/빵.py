import sys
input = sys.stdin.readline

T = int(input())

result = 100001

for i in range(T) :
    A, B = map(int, input().split())

    if A - B <= 0 :
        result = min(B, result)

if result == 100001 :
    print(-1)
else :
    print(result)
