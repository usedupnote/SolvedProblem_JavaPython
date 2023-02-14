import sys
input = sys.stdin.readline

T = list(input().strip())

result = 10

if T != 1 :
    for i in range(1, len(T)) :
        if T[i-1] == T[i] :
            result += 5
        else :
            result += 10

print(result)