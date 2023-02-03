import sys

N, M = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))

start, end = 0, max(trees)

while start <= end :
    mid = (start + end) // 2
    result = 0

    for i in trees :
        if i >= mid :
            result += i - mid
    if result >= M :
        start = mid + 1
    else :
        end = mid - 1

print(end)