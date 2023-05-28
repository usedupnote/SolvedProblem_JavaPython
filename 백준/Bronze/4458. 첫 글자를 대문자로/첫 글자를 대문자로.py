import sys
input = sys.stdin.readline

N = int(input())
for i in range(N) :
    S = input().strip()
    print(S[0].upper(), end="")
    print(S[1:])