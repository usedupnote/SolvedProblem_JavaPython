n = int(input())

num = [0,1]

for i in range(1, n) :
    num.append(num[i-1] + num[i])
print(num[n])