import sys
input = sys.stdin.readline

fingerCounter = int(input())

fingerCounter = (fingerCounter - 1) % 8

if fingerCounter < 5:
    print(fingerCounter + 1)
else :
    print(9 - fingerCounter)