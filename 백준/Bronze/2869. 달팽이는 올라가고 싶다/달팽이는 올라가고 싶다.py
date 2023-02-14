num = list(map(int, input().split()))
day = 1

day += (num[2] - num[0]) / (num[0] - num[1])
if day%1 != 0 :
    day += 1
print(int(day))