import sys
input = sys.stdin.readline
T = int(input())
for test_case in range(T) :
    A, B = map(int, input().split())
    print("Case ", test_case + 1,": ", A + B, sep="")