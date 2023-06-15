import sys
input = sys.stdin.readline

A,B = map(int, input().split())

minV,maxV = 0,0

i = 0
while A != 0 :
    numA = A%10
    A //= 10
    if numA == 5 or numA == 6 :
        minV += 5 * int(10 ** i)
        maxV += 6 * int(10 ** i)
    else :
        minV += numA * int(10 ** i)
        maxV += numA * int(10 ** i)
    i+=1

i = 0
while B != 0 :
    numB = B % 10
    B //= 10
    if numB == 5 or numB == 6 :
        minV += 5 * int(10 ** i)
        maxV += 6 * int(10 ** i)
    else :
        minV += numB * int(10 ** i)
        maxV += numB * int(10 ** i)
    i+=1

print(minV, maxV)