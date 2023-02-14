import sys
input = sys.stdin.readline

T = int(input())
num = list(map(int, input().split()))

num.sort()

print(sum(num[:len(num)-1]))