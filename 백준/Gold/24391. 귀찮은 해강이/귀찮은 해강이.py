import sys
input = sys.stdin.readline

def connectUnion(x, y):
    a = unionFind(x)
    b = unionFind(y)
    if a > b:
        union[a] = b
    else:
        union[b] = a

def unionFind(x):
    if union[x] != x:
        union[x] = unionFind(union[x])
    return union[x]

N, M = map(int, input().split())

union = [0] * (N + 1)

for i in range(N + 1):
    union[i] = i

for i in range(M):
    pos1, pos2 = map(int, input().split())
    connectUnion(pos1, pos2)

result = 0
edu = list(map(int, input().split()))

for i in range(1, len(edu)):
    if unionFind(edu[i]) != unionFind(edu[i - 1]):
        result += 1

print(result)