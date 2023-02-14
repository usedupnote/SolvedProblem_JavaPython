N = int(input())

num = input().split()

min = int(num[0])
max = min

for i in range(1, N) :
    checker = int(num[i])
    if (min > checker) :
        min = checker
    elif (max < checker) :
        max = checker
print(min, max, sep = " ")