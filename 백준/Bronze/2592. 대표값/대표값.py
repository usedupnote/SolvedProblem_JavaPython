import sys
input = sys.stdin.readline

num = []

for i in range(10):
    num.append(int(input()))

num.sort()

mean = sum(num) // 10
mode = 0

check = 1
maximum = 0

for i in range(1, 10):
    if num[i] == num[i - 1]:
        check += 1
    else:
        if maximum < check:
            mode = num[i - 1]
            maximum = check
        check = 0

print(mean, mode, sep="\n")