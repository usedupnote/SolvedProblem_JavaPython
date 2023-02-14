import sys

num = list(sys.stdin.readline().strip())

result = 0

for i in num :
    if i == "0" :
        result += 9
    else :
        result += int(i)

print(result)