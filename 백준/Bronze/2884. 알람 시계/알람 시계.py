hour, min = input().split()

hour = int(hour)
min = int(min)

if min - 45 < 0 :
    print((hour - 1) % 24, min + 15)
else :
    print((hour) % 24, min - 45)