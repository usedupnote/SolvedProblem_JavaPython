import sys
input = sys.stdin.readline

for i in range(3) :
    game = list(map(int, input().split()))
    cnt = 0

    for j in range(4) :
        if game[j] == 0 :
            cnt += 1

    if cnt == 0 :
        cnt = 5

    print(chr(cnt + ord('A') - 1))