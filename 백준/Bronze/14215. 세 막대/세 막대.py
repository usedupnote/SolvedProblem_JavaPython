import sys
input = sys.stdin.readline

num = list(map(int, input().split()))
num.sort()

result = num[0] + num[1]
if result <= num[2] :
    result += result - 1
else :
    result += num[2]
print(result)