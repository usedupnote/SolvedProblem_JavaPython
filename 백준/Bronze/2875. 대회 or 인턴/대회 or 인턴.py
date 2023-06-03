import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())

result = min(N//2, M)
K -= (N-(result *2)) + (M-result)
if K > 0 :
    result -= (K+2)//3

print(result)
