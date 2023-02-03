import sys

N = int(sys.stdin.readline())

result = 0

rope = []

for i in range(N) :
    rope.append(int(sys.stdin.readline()))

rope.sort(reverse=True)

for i in range(N) :
    result = max(result, rope[i] * (i+1))

print(result)