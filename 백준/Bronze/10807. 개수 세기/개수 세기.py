result = 0

N = int(input())
num = input().split()
checkNum = int(input())

for i in range(N) :
    num[i] = int(num[i])
    if checkNum == num[i] :
        result += 1
print(result)