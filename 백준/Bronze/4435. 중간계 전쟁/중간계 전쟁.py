import sys
input = sys.stdin.readline

teamA = [1, 2, 3, 3, 4, 10]
teamB = [1, 2, 2, 2, 3, 5, 10]

T = int(input())

for TC in range(1, T + 1):
    A = 0
    B = 0

    tA = list(map(int, input().split()))
    tB = list(map(int, input().split()))

    for i in range(6):
        A += (tA[i] * teamA[i])
        B += (tB[i] * teamB[i])
    B += (tB[6] * teamB[6])

    print("Battle ", TC, ": ", ("Good triumphs over Evil" if A > B else ("Evil eradicates all trace of Good" if A < B else "No victor on this battle field")), sep="")