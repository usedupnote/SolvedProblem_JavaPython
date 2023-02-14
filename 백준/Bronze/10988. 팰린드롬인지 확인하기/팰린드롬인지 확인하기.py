import sys
T = list(sys.stdin.readline().strip())

result = 1

for i in range(len(T) // 2) :
    if T[i] != T[-i - 1] :
        result = 0
        break

print(result)