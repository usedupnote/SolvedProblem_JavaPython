n, k = map(int, input().split())  # N은 앉아있는 사람의 수 / K는 제거되는 사람의 순번

num = []
result = []

check = 0

for i in range(1, n + 1) :
    num.append(i)

for i in range(n) :
    check = (check + k -1) % len(num)
    result.append(num.pop(check))


print("<", ", ".join(str(i) for i in result), ">", sep="")