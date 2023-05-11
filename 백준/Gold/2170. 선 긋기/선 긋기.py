import sys
input = sys.stdin.readline

N = int(input())
line = []

for i in range(N):
    line.append(tuple(map(int, input().split())))

line.sort()
start, end = line[0]
result = 0

for i in range(1, N):
    pop = line[i]

    if end < pop[0] :
        result += end - start
        start, end = pop
        continue

    end = max(end, pop[1])
result += end - start
print(result)