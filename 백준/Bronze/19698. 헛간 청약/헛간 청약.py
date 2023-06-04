import sys
input = sys.stdin.readline

N, W, H, L = map(int, input().split())

W //= L
H //= L

result = W * H

print(min(result, N))
