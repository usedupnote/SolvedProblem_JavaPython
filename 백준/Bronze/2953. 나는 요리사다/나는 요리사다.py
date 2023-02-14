import sys
input = sys.stdin.readline

result = []

for i in range(5) :
    result.append([i+1, sum(list(map(int, input().split())))])

result.sort(key= lambda x:x[1])

print(*result[4])