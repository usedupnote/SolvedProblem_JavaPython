import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num = [[N, 1]]

result = -1

while len(num) != 0 :
    pop = num.pop(0)

    if pop[0] == M :
        result = pop[1]
        break

    elif pop[0] < M :
        num.append([pop[0]*2, pop[1] + 1])
        num.append([pop[0]*10+1, pop[1] + 1])

print(result)