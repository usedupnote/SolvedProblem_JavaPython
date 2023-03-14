import sys
input = sys.stdin.readline

result = 0
minimum = 987654321

for i in range(7) :
    num = int(input())

    if num % 2 != 0 :
        result += num
        minimum = min(minimum, num)

if result == 0 :
    print(-1)
else :
    print(result, minimum, sep="\n")