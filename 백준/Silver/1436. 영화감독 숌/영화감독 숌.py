import sys

T = int(input())

count = 0
check = 666
while True :
    if "666" in str(check) :
        count += 1

    if count == T :
        break

    check += 1

print(check)