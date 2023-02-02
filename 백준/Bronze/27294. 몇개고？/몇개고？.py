import sys
input = sys.stdin.readline

T, S = map(int, input().split())

result = 280

if S != 1 :
    if T > 11 and T < 17 :
        result = 320

print(result)