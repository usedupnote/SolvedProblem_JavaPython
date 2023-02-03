import sys

T = int(input())
num = []
for i in range(T) :
    case = int(input())

    if case == 0 :
        num.pop()
    else :
        num.append(case)

print(sum(num))