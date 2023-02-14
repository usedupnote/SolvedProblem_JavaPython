N = int(input())    # 숫자의 개수
num = list(input())

sum = 0

for i in range(len(num)) :
    sum += int(num[i])

print(sum)