import sys
input = sys.stdin.readline

T = int(input())

num = []

for i in range(T) :
    num.append(int(input()))

for i in num :
    print("even" if i % 2 == 0 else "odd")