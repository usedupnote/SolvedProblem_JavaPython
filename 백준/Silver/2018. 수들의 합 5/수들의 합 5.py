import sys

T = int(sys.stdin.readline())

startPoint = 1
endPoint = 1

result = 1
checkNum = 1

while startPoint < T//2 + 1 :
    if checkNum == T :
        result += 1
        checkNum -= startPoint
        startPoint += 1
    elif checkNum < T :
        endPoint += 1
        checkNum += endPoint
    else :
        checkNum -= startPoint
        startPoint += 1

print(result)