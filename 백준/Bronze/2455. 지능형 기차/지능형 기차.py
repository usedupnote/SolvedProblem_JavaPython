import sys

amountOfChange = 0
maximum = 0

for i in range(4) :
    flowPerson = list(map(int, sys.stdin.readline().split()))
    amountOfChange += flowPerson[1] - flowPerson[0]
    maximum = max(maximum, amountOfChange)

print(maximum)