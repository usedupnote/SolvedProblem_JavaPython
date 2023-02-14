N = int(input())

N = (N - 2) // 6

i = 1

while N >= 0:
    N -= i
    i += 1
print(i)