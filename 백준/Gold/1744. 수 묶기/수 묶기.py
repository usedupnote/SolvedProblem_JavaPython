import sys
input = sys.stdin.readline

result = 0
N = int(input())

posNum = []
nagNum = []

for i in range(N):
    n = int(input())
    if n > 0:
        posNum.append(n)
    else :
        nagNum.append(n)

posNum.sort(reverse=True)
nagNum.sort()
while len(posNum) :
    if len(posNum) == 1:
        result += posNum[0]
    else :
        if posNum[1] == 1:
            result += posNum[0]
        else :
            result += posNum[0] * posNum[1]
            posNum.pop(0)
    posNum.pop(0)

while len(nagNum) :
    if len(nagNum) == 1:
        result += nagNum[0]
    else :
        result += nagNum[0] * nagNum[1]
        nagNum.pop(0)

    nagNum.pop(0)
print(result)