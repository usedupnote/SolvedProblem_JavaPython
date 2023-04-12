N = int(input())

ground = [['X' for _ in range(N+1)] for _ in range(N+1)]

for i in range(N) :
    current = input()
    for j in range(N) :
        if current[j] == 'X' : continue
        ground[i][j] = '.'

dirX = [0,1]
dirY = [1,0]

check = 0
cnt = [0, 0]

for i in range(N):
    check = 0
    for j in range(N):
        if ground[i][j] == 'X':
            if check >= 2 :
                cnt[0] += 1
            check = 0
            continue
        check += 1
    if check >= 2:
        cnt[0] += 1

for i in range(N):
    check = 0
    for j in range(N):
        if ground[j][i] == 'X':
            if check >= 2 :
                cnt[1] += 1
            check = 0
            continue
        check += 1
    if check >= 2:
        cnt[1] += 1

print(cnt[0], cnt[1])