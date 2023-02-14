import sys
input = sys.stdin.readline

text = list(input().strip())

point = 0

while True :
    if point + 10 > len(text) :
        print(*text[point:], sep="")
        break
    else :
        print(*text[point:point+10], sep="")
    point += 10