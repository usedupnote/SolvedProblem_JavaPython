num = input().split()

for i in range(len(num)) :
    num[i] = int(num[i])

count = (min(num) // 2)

check = 0


if (max(num) % min(num)) != 0 :
    for i in range(count, 0, -1) :
        if num[0] % i == 0 and num[1] % i == 0 :
            check = i
            break
else :
    check = min(num)
    
print(check)
print(num[0] * num[1] // check)