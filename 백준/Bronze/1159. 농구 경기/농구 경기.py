import sys
input = sys.stdin.readline

N = int(input())

player = []
result = []

for _ in range(N):
    player.append(list(input().strip()))

player.sort()

count = 1

for i in range(1, N):
    if player[i][0] == player[i-1][0] :
        count += 1

    else :
        if count > 4 :
            result.append(list(player[i-1][0]))
        count = 1

if count > 4 :
    result.append(list(player[len(player) - 1][0]))

lenResult = len(result)

if lenResult == 0 :
    print("PREDAJA")
else :
    for i in range(lenResult):
        print(result[i][0], end="")