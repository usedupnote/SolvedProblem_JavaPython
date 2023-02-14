import sys
input = sys.stdin.readline

num = int(input())

for i in range(1, num + 1) :
    if i == num :
        print("*" * (num * 2 - 1))
    elif i == 1 :
        print(" " * (num - i - 1), "*")
    else :
        print(" " * (num - i), "*", " " * ((i - 1) * 2 - 1), "*", sep="")