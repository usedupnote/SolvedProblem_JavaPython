result = []

n, m = input().split()

checker = []

n = int(n)
m = int(m)

for i in range(n) :
    result.append([])
    for j in range(m) :
        result[i].append(0)

for k in range(2) :
    for i in range(n) :
        checker = input().split()
        for j in range(m) :
            result[i][j] += int(checker[j])

for i in range(n) :
    for j in range(m) :
        print(result[i][j], end = " ")
    print("")