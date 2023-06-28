import sys
input = sys.stdin.readline

while True :
    l = list(input().replace("\n", ""))
    l.reverse()
    result = ""
    for i in l :
        result+=i
    if result == "***" :
        break
    print(result)