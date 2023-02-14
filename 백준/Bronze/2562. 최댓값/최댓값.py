num = []

for i in range(9) :
    num.append(int(input()))

maximum = max(num)

for i in range(9) :
    if num[i] == maximum :
        print(num[i])
        print(i+1)