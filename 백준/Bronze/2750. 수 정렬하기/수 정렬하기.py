N = int(input())

num = []

for i in range(N) :
    num.append(int(input()))
set(num)
num.sort()

for i in range(len(num)) :
    print(num[i])