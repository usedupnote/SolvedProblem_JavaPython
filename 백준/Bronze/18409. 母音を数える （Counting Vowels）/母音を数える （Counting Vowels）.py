check = ['a','e','i','o','u']

input()
S = list(input())

cnt = 0

for i in check :
    cnt += S.count(i)

print(cnt)