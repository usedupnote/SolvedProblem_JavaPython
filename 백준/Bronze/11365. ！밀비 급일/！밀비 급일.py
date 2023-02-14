import sys

input = sys.stdin.readline

code = input().strip()

while code != "END" :
    code = list(code)
    code.reverse()

    print(*code, sep="")

    code = input().strip()