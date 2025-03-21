import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
s = int(input())

lenA = len(A)
V = [True for _ in range(lenA)]
V[s-1] = False
C = [s-1]

while C:
    minusC = C[0] - A[C[0]]
    plusC = C[0] + A[C[0]]

    if minusC >= 0 and V[minusC]:
        C.append(minusC)
        V[minusC] = False

    if plusC < lenA and V[plusC]:
        C.append(plusC)
        V[plusC] = False
    C.pop(0)

print(V.count(False))