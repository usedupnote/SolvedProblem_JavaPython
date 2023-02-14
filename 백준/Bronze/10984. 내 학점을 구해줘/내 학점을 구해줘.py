import sys

T = int(sys.stdin.readline())

for i in range(T) :
    result = [0, 0]
    N = int(sys.stdin.readline())
    for j in range(N) :
        C, G = sys.stdin.readline().split()

        C = int(C)
        G = float(G)

        result[0] += C
        result[1] += G * C

    result[1] = (result[1] / result[0])
    print(result[0], format(result[1], ".1f"))