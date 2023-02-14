a = list(input())

num = []
maximum = 0

for i in range(10) :
    num.append(0)

for i in a :
    num[int(i)] += 1

num[6] += num.pop()
num[6] = (num[6]//2) + (0 if num[6] % 2 == 0 else 1)

for i in range(9) :
    maximum = max(maximum, num[i])

print(maximum)