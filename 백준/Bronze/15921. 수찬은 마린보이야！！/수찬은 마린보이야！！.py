import sys
input = sys.stdin.readline

N = int(input())

if N != 0 :
    num = list(map(int, input().split()))
    if sum(num) != 0 :
        ans = sum(num) / N / (sum(num) / N)
        print("%.2f" % ans)
    else :
        print("divide by zero")
else :
    print("divide by zero")