import sys
input = sys.stdin.readline

s = list(input())

c = ['a','e','i','o','u']

result = 0
for i in c :
    result += s.count(i)
print(result)