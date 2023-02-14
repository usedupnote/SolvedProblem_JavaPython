import sys
input = sys.stdin.readline

T = int(input())

num = [1, 2, 4]
point = []

for i in range(T):
    point.append(int(input()))
    
for i in range(2, 1000001):
    num.append((num[i-2] + num[i - 1] + num[i]) % 1000000009)

for i in point:
    print(num[i - 1])