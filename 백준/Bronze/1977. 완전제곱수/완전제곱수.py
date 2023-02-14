import sys

small = int(sys.stdin.readline())
large = int(int(sys.stdin.readline()) ** (1/2))

counter = int(small ** (1/2)) + 1

if small == 1 :
    num = [1]
else :
    num = []

while counter <= large :
    num.append(counter ** 2)
    counter += 1

if len(num) == 0 :
    print(-1)
else :
    print(sum(num))
    print(num[0])