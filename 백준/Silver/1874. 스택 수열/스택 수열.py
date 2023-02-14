import sys

N = int(sys.stdin.readline())

num = []

for i in range(0, N + 1) :
    num.append(i)

check = 0

result = []

for i in range(N) :
    count = int(sys.stdin.readline())

    while True :
        if count > num[check] :
            check += 1
            result.append("+")
        elif count < num[check] :
            result = ["NO"]
            break
        else :
            result.append("-")
            num.pop(check)
            check -= 1
            break
    if result[0] == "NO" :
        break

for i in result :
    print(i)