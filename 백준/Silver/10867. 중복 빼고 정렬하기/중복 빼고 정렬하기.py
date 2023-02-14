N = int(input())
num = list(set(map(int, input().split())))

num.sort()

print(*num)