import sys

while True :
    try:
        N = list(map(int, sys.stdin.readline().split()))
        print(max(N[2] - N[1], N[1] - N[0]) - 1)
    except:
        break