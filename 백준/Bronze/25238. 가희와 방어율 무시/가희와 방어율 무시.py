a, b = map(int, input().split())

if a - (a/100 * b) < 100 :
    print(1)
else :
    print(0)
