import sys

n = int(sys.stdin.readline())

for i in range(n) :
    p = int(sys.stdin.readline())

    playerGet = list(sys.stdin.readline().split())
    playerGet[0] = int(playerGet[0])
    count = 1

    while True :
        if count == p :
            break
        player = list(sys.stdin.readline().split())
        if int(player[0]) > playerGet[0] :
            playerGet = player
            playerGet[0] = int(playerGet[0])
        count += 1

    print(playerGet[1])