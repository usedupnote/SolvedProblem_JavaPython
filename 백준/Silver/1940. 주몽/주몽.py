import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

num = list(map(int, input().split()))

num.sort()

start = 0
end = N - 1

result = 0

while start < end :
    check = num[start] + num[end]

    if check == M :
        result += 1
        start += 1
        end -= 1
        continue
    elif check > M :
        end -= 1
        continue
    else :
        start += 1
        continue

print(result)