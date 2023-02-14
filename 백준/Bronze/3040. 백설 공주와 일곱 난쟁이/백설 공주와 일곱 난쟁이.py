num = []
for i in range(9):
    num.append(int(input()))

check = sum(num) - 100

for i in range(8):
    for j in range(1,9):
        if num[i] + num[j] == check:
            num.pop(j)
            num.pop(i)
            break
    if len(num) == 7:
        break

print(*num, sep="\n")