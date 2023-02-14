import sys

num = list(map(int, sys.stdin.readline().split()))

result = "S"

for i in num :
    if i == 9 :
        result = "F"
print(result)