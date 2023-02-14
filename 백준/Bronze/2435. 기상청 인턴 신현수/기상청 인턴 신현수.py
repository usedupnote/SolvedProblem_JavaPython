import sys

N, K = map(int, sys.stdin.readline().split())
temp = list(map(int, sys.stdin.readline().split()))

result = -9999

for i in range(N-K+1) :
    compare = 0
    for j in range(i, i+K) :
        compare += temp[j]
    result = max(result, compare)
   
print(result)