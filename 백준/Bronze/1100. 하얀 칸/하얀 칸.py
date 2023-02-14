result = 0
for i in range(8) :
    chess = list(input())
    for j in range(i%2, 8, 2) :
        if chess[j] == "F" :
            result += 1
print(result)