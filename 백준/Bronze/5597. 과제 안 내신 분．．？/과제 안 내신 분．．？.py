result = []

for i in range(31) :
    result.append(0)

for i in range(1,29) :
    result[int(input())] += 1

for i in range(1, 31) :
    if result[i] == 0 :
        print(i)