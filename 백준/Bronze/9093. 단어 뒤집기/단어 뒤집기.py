import sys

T = int(sys.stdin.readline())

for i in range(T) :
    sentence = list(sys.stdin.readline().split())

    for j in sentence :
        word = list(j)
        word.reverse()

        print(*word, sep="", end=" ")

    print()
