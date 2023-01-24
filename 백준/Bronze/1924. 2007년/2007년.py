import sys
input = sys.stdin.readline

month, day = map(int, input().split())

result = 0

day30Month = [4, 6, 9, 11]

week = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]

for i in range(1, month) :

    if i == 2:
        result += 28
    elif i in day30Month:
        result += 30
    else:
        result += 31

result += day

print(week[result%7])