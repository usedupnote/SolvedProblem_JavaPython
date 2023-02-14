def Rev(num) :
    num = list(str(num))
    num.reverse()
    num = "".join(num)
    num = int(num)

    return num

import sys

X, Y = map(int, sys.stdin.readline().split())

print(Rev(Rev(X) + Rev(Y)))