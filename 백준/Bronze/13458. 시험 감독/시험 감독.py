import sys

T = int(sys.stdin.readline())

A = list(map(int, sys.stdin.readline().split()))
B, C = map(int, sys.stdin.readline().split())

result = T

for i in A:
    compare = i - B
    if compare < 0 :
        compare = 0
    
    result += (compare // C) + (0 if compare % C == 0 else 1)
print(result)
