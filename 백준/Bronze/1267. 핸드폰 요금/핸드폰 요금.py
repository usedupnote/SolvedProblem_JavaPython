import sys

T = int(sys.stdin.readline())

call = list(map(int, sys.stdin.readline().split()))

resultA = 0
resultB = 0

for i in call :
    resultA += i // 30 + 1
    resultB += i // 60 + 1

resultA *= 10
resultB *= 15

if resultA > resultB :
    print("M {}".format(resultB))
elif resultA == resultB :
    print("Y M {}".format(resultA))
else:
    print("Y {}".format(resultA))