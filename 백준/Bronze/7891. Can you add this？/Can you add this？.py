import sys
input = sys.stdin.readline

T = int(input())

for test_case in range(T) :
    N, M = map(int, input().split())
    print(N + M)