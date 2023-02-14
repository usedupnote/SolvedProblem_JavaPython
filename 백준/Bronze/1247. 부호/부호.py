import sys

for i in range(3) :
    T = int(sys.stdin.readline().strip())
    result = 0

    for j in range(T) :
        result += int(sys.stdin.readline().strip())

    if result > 0 : print("+")
    elif result < 0 : print("-")
    else : print(0)