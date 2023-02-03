import sys

count = 0
num = int(sys.stdin.readline())

while num != 0 :
    count += 1
    song = []
    for i in range(num) :
        song.append(sys.stdin.readline().strip())

    song.sort()

    print(count)
    print(*song,sep="\n")

    num = int(sys.stdin.readline()) 