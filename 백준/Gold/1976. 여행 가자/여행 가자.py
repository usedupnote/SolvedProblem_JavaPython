import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

A = [[0 * N] for _ in range(N)]

for i in range(N) :
        A[i] = list(map(int, input().split()))

root = list(map(int, input().split()))

result = "YES"

v = [0 for i in range(N)]

queue = [root[0] - 1]
v[root[0] - 1] = 1

while len(queue) != 0:
    pop = queue.pop()

    for i in range(N) :
        if v[i] != 1 and A[pop][i] == 1 :
            v[i] = 1
            queue.append(i)

for i in range(M) :
    if v[root[i] - 1] != 1 :
        result = "NO"
        break

print(result)
