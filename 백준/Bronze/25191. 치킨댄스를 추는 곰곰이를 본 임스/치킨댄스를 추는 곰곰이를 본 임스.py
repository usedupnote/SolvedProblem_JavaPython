import sys
input = sys.stdin.readline

N = int(input())
A, B = map(int, input().split())
print(list(map(lambda x : N - x if x > 0 else N, [N - (B + A//2)]))[0])