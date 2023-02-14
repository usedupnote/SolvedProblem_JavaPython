result = 0
num = input().split()

# 고유번호의 처음 5자리
for i in range(5):
    num[i] = int(num[i])
    result += num[i] ** 2

# 검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.
num.append(result % 10)

print(num[5])