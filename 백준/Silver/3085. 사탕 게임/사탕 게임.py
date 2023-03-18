import sys
input = sys.stdin.readline

dirX = [1, 0] #우 하
dirY = [0, 1]

N = int(input())
result = 0

map = [(['A'] * N) for _ in range(N)]

for i in range(N) :
    ch = input()
    for j in range(N) :
        map[i][j] = ch[j]

def countCandy() :
    compare = 0
    for i in range(N):
        cnt = 1
        for j in range(N-1) :
            if map[i][j] == map[i][j+1] :
                cnt += 1
            else :
                compare = max(compare, cnt)
                cnt = 1
        compare = max(compare, cnt)


    for j in range(N):
        cnt = 1
        for i in range(N-1):
            if map[i][j] == map[i+1][j] :
                cnt += 1
            else :
                compare = max(compare, cnt)
                cnt = 1
        compare = max(compare, cnt)

    return compare

def convert() :
    compare = 0
    for i in range(N):
        for j in range(N):
            for d in range(2):
                dx = i + dirX[d]
                dy = j + dirY[d]
                if 0 <= dx and dx < N and 0 <= dy and dy < N:
                    if map[dx][dy] != map[i][j]:
                        change = map[i][j]
                        map[i][j] = map[dx][dy]
                        map[dx][dy] = change

                        compare = max(compare, countCandy())

                        map[dx][dy] = map[i][j]
                        map[i][j] = change
    return compare

result = convert()

print(result)