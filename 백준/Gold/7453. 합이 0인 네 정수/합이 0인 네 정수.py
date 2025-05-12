import sys
from collections import defaultdict

input = sys.stdin.readline
n = int(input())
A, B, C, D = [], [], [], []
for _ in range(n):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

first = defaultdict(int)
for i in range(n):
    for j in range(n):
        A_B = A[i] + B[j]
        first[A_B] += 1

answer = 0
for i in range(n):
    for j in range(n):
        C_D = C[i] + D[j]
        if first.get(-C_D):
            answer += first.get(-C_D)

print(answer)