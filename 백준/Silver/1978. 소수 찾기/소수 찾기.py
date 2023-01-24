N = int(input())

result = 0

num = input().split()

for i in range(N) :
    num[i] = int(num[i])
    
    if num[i] == 1 :
        result += 1
    else :
        for j in range(2, int(num[i] ** (1/2)) + 1) :
            if num[i] % j == 0 :
                result += 1
                break

print(N - result)