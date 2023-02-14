N = int(input())

data = []

for i in range(1,N + 1) :
    data.append(i)

for i in range(N - 1) :
    print(data.pop(0), end=" ")
    data.append(data.pop(0))
print(data.pop(0))