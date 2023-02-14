import sys
input = sys.stdin.readline

num = int(input())

result = 0

while num >= 10 :
    num = sum(map(int, list(str(num))))
    result += 1

print(result)

if num % 3 == 0 :
    print("YES")
else :
    print("NO")