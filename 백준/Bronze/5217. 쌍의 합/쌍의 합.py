import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    N = int(input())

    A = 1
    B = N - 1

    print("Pairs for ", N, ": ", sep="", end="")

    if A < B :
        print(A, B, sep=" ", end="")

    A += 1
    B -= 1

    while A < B :
        print(", ", A, " ", B, sep="", end="")

        A += 1
        B -= 1
    print()