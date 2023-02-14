import sys

while True :
    player = list(sys.stdin.readline().split())

    for i in range(1, 3) :
        player[i] = int(player[i])

    if player[0] == "#" and player[1] == 0 and player[2] == 0 :
        break

    if player[1] > 17 or player[2] >= 80 :
        print(player[0], "Senior")
    else :
        print(player[0], "Junior")