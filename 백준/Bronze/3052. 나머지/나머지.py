count = []

for i in range(42) :
    count.append(0)

for i in range(10) :
    count[int(input()) % 42] = 1

print(sum(count))