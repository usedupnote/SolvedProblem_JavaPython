import sys
input = sys.stdin.readline

T = int(input())

count = 0

for _ in range(T):
    day = list(input().strip())
    num = int("".join(day[2:]))

    if num <= 90 :
        count += 1

print(count)