import sys
input = sys.stdin.readline

def FibS(N) :
    FibonS = []

    for i in range(N):
        if i < 3:
            FibonS.append(1)
            continue

        FibonS.append(FibonS[i - 1] + FibonS[i - 3])
    return FibonS[N-1]

print(FibS(int(input())))