import sys
input = sys.stdin.readline

num = int(input())

latter = [1, 0]

for i in range(num) :
    latter = [latter[1], latter[0] + latter[1]]

print(*latter)