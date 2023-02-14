import sys
input = sys.stdin.readline

num = bin(int(input()))
num = num[2:]
num = num[::-1]

print(int(num, 2))