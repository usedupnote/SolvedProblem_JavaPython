a = input().split()

for i in range(len(a)) :
    a[i] = int(a[i])

a.sort()

print(a[1])