import sys
input = sys.stdin.readline

A,B,C = map(int, input().split())
B *= 2
C *= 3
price = 0
time = [0 for _ in range(101)]

for i in range(3) :
    sta, end = map(int, input().split())
    for j in range(sta, end) :
        time[j] += 1

for i in range(101) :
    if time[i] == 1 :
        price += A
    elif time[i] == 2:
        price += B
    elif time[i] == 3 :
        price += C

print(price)