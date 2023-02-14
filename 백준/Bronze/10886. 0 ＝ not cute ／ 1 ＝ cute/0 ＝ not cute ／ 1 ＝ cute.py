import sys

T = int(sys.stdin.readline())

result = 0

for i in range(T):
    result += int(sys.stdin.readline())

if T - result > result :
    print("Junhee is not cute!")
else :
    print("Junhee is cute!")