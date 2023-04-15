import sys
input = sys.stdin.readline

T = int(input())

while True :
    N = int(input())
    if N == 0: break
    if N % T == 0: print(N, " is a multiple of ", T, ".", sep="")
    else: print(N, " is NOT a multiple of ", T, ".", sep="")