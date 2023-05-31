import sys
input = sys.stdin.readline
cnt = []
for i in range(8):
    cnt.append([int(input()), i + 1])

cnt.sort()
for i in range(3) :
    cnt.pop(0)
cnt.sort(key=lambda x:x[1])

result = 0
for i in cnt:
    result += i[0]

print(result)
for i in cnt:
    print(i[1], end=" ")