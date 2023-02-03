import sys

K, N = map(int, sys.stdin.readline().split())

lanCable = []

for i in range(K) :
    lanCable.append(int(sys.stdin.readline()))

start, end = 1, sum(lanCable)//N

while start <= end :
    mid = (start + end) // 2
    result = 0
    for j in lanCable :
        result += j // mid

    if result >= N :
        start = mid + 1
    else :
        end = mid - 1

print(end)