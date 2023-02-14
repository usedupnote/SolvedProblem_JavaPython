import sys

N = sys.stdin.readline()

result = 0

for i in range(1, len(N)-1) :
    if N[i-1] != N[i] :
        result += 1

print(result // 2 + (1 if result % 2 == 1 else 0))