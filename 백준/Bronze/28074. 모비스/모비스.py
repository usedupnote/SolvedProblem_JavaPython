import sys
input = sys.stdin.readline

check = ["M", "O", "B", "I", "S"]
tW = list(input())

for i in range(5) :
    if tW.count(check[0]) != 0 :
        check.pop(0)
    else :
        break
if len(check) == 0 :
    print("YES")
else :
    print("NO")