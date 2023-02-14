num = input().split()
result = [0, 0]
for i in range(2) :
    num[i] = int(num[i])
    for j in range(3) :
        result[i] += (num[i] % 10) * (10 ** (2 - j))
        num[i] = num[i] // 10



if result[0] > result[1] :
    print(result[0])
else :
    print(result[1])