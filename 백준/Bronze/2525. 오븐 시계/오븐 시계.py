hour, minute = input().split()
time = int(input())

hour = int(hour)
minute = int(minute) + time

hour = hour + (minute // 60)
minute = minute % 60
hour = hour % 24

print(hour, minute)